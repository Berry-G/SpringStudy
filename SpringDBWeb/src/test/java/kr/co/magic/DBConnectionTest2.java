package kr.co.magic;

import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionTest2
{
	@Autowired
	DataSource ds;
	
	@Test
	public void springJdbcConnectionTest3() throws SQLException
	{
		// 1) 데이터베이스의 연결을 얻음.
		Connection conn = ds.getConnection();

		// 괄호안의 조건식이 true면 테스트 성공, 아니면 실패
		assertTrue(conn != null);
	}

}
