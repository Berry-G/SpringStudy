package kr.co.magic;

import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest
{
	public static void main(String[] args) throws SQLException
	{
		/*
		 * String DB_URL = "jdbc:postgresql://localhost:5432/ezendb"; String DB_user =
		 * "postgres"; String DB_PASSWORD = "0111";
		 * 
		 * // 1) 데이터베이스의 연결을 얻음. Connection conn = DriverManager.getConnection(DB_URL,
		 * DB_user, DB_PASSWORD);
		 * 
		 * // 2) Statement 객체 생성 Statement stmt = conn.createStatement();
		 * 
		 * // 시스템의 현 날짜 시간 출력하는 쿼리 String query = "select now()";
		 * 
		 * // 3) Statement 객체의 executeQuery() 실행해서 ResultSet 객체를 생성. // query 실행 결과를 rs에
		 * 담음 ResultSet rs = stmt.executeQuery(query);
		 * 
		 * //실행결과 담긴 rs에서 한줄씩 읽어서 출력 while (rs.next()) { String curDate =
		 * rs.getString(1); System.out.println(curDate); }
		 */
		
		ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
		
		DataSource ds = ac.getBean(DataSource.class);
		
		// 1) 데이터베이스의 연결을 얻음.		
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
		
		//괄호안의 조건식이 true면 테스트 성공, 아니면 실
	}

}
