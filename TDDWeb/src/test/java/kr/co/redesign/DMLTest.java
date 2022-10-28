package kr.co.redesign;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/Web-INF/spring/**/root-context.xml" })
public class DMLTest
{
	@Autowired
	DataSource ds;

	@Test
	public void springJdbcConnTest() throws SQLException
	{
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
		assertTrue(conn != null);
	}

	@Test
	public void insertUserTest() throws SQLException
	{
		User user = new User("ezen", "0111", "ezen", "ezen@gmail.com", new Date(), "fb", new Date());
		deleteAll();
		int rowCnt = insertUser(user);

		assertTrue(rowCnt == 1);
	}

	private void deleteAll() throws SQLException
	{
		Connection conn = ds.getConnection();
		String sql = "delete from t_user";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
	public int deleteUser(String id) throws SQLException
	{
		Connection conn = ds.getConnection();
		String sql = "delete from t_user where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
	}
	
	public int insertUser(User user) throws SQLException
	{
		Connection conn = ds.getConnection();

		String sql = "insert into t_user values (?, ?, ?, ?, ?, ?, now())";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUser_id());
		pstmt.setString(2, user.getUser_pw());
		pstmt.setString(3, user.getUser_name());
		pstmt.setString(4, user.getUser_email());
		pstmt.setDate(5, new java.sql.Date(user.getUser_birth().getTime()));
		pstmt.setString(6, user.getUser_sns());

		int rowCnt = pstmt.executeUpdate();
		return rowCnt;
	}
	
	@Test
	public void selectUserTest() throws SQLException
	{
		deleteAll();
		User user = new User("ezen", "0111", "ezen", "ezen@gmail.com", new Date(), "fb", new Date());
		int rowCnt = insertUser(user);
		User user2 = selectUser("ezen");
		
		assertTrue(user.getUser_id().equals("ezen"));
	}
	
	
	public User selectUser(String id) throws SQLException
	{
		Connection conn = ds.getConnection();

		String sql = "select * from t_user where id = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next())
		{
			User user = new User();
			user.setUser_id(rs.getString(1));
			user.setUser_pw(rs.getString(2));
			user.setUser_name(rs.getString(3));
			user.setUser_email(rs.getString(4));
			user.setUser_birth(new Date(rs.getDate(5).getTime()));
			user.setUser_sns(rs.getString(6));
			user.setUser_create_date(new Date(rs.getDate(7).getTime()));
		}
		return null;
	}
	
	@Test
	public void updateUserTest() throws SQLException
	{
		deleteAll();
		User user = new User("ezen5", "0111", "ezen5", "ezen@gmail.com", new Date(), "insta", new Date());
		int rowCnt = insertUser(user);
		assertTrue(rowCnt==1);
		
		user.setUser_pw("0112");
		user.setUser_name("ezen6");
		user.setUser_email("ezen6@gmail.com");
		rowCnt = updateUser(user);
		assertTrue(rowCnt==1);
	}
	
	
	public int updateUser(User user) throws SQLException
	{
		Connection conn = ds.getConnection();
		
		String sql = "update t_user "
				+ "set pwd = ?, name = ?, email = ?, birth = ?, sns = ?, reg_date = ? "
				+ "where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//pstmt.setString(1, user.getUser_id());
		pstmt.setString(1, user.getUser_pw());
		pstmt.setString(2, user.getUser_name());
		pstmt.setString(3, user.getUser_email());
		pstmt.setDate(4, new java.sql.Date(user.getUser_birth().getTime()));
		pstmt.setString(5, user.getUser_sns());
		pstmt.setDate(6, new java.sql.Date(user.getUser_birth().getTime()));
		pstmt.setString(7, user.getUser_id());
		
		return pstmt.executeUpdate();
	}

}
