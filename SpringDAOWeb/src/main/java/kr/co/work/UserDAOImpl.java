package kr.co.work;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	DataSource ds;

	final int FAIL = 0;

	public User selectUser(String id)
	{
		User user = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from t_user where id = ? ";

		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next())
			{
				user = new User();
				user.setUser_id(rs.getString(1));
				user.setUser_pw(rs.getString(2));
				user.setUser_name(rs.getString(3));
				user.setUser_email(rs.getString(4));
				user.setUser_birth(new Date(rs.getDate(5).getTime()));
				user.setUser_sns(rs.getString(6));
				user.setUser_create_date(new Date(rs.getTimestamp(7).getTime()));
			}
		} catch (SQLException e)
		{
			return null;
		} finally
		{
			if(rs != null)
//			if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace();}}
//			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace();}}
//			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace();}}
			close(rs, conn, pstmt);
		}

		return user;
	}

	@Override
	public void deleteAll() throws SQLException
	{
		Connection conn = ds.getConnection();

		String sql = "delete from t_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
	@Override
	public int insertUser(User user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into t_user values (?, ?, ?, ?, ?, ?, now())";
		
		try
		{
	         conn = ds.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, user.getUser_id());
	         pstmt.setString(2,  user.getUser_pw());
	         pstmt.setString(3, user.getUser_name());
	         pstmt.setString(4, user.getUser_email());
	         pstmt.setDate(5, new java.sql.Date(user.getUser_birth().getTime()));
	         pstmt.setString(6, user.getUser_sns());			

			return pstmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
			return FAIL;
		} finally
		{
			close(pstmt, conn);
		}

	}

	private void close(AutoCloseable... closeables)
	{
		for (AutoCloseable autoCloseable : closeables)
		{
			try
			{
				if (autoCloseable != null)
				{
					autoCloseable.close();
				}
			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int updateUser(User user)
	{
		int rowCnt = FAIL;
		
		String sql = "update t_user "
				+ "set pwd = ?, name = ?, email = ?, birth = ?, sns = ?, reg_date = ? "
				+ "where id = ? ";
		
		//try-with-resources
		try(
		         Connection conn = ds.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql);            
		      )
		{
			pstmt.setString(1, user.getUser_pw());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_email());
			pstmt.setDate(4, new java.sql.Date(user.getUser_birth().getTime()));
			pstmt.setString(5, user.getUser_sns());
			pstmt.setDate(6, new java.sql.Date(user.getUser_birth().getTime()));
			pstmt.setString(7, user.getUser_id());
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return FAIL;
		}
		

		//pstmt.setString(1, user.getUser_id());		PreparedStatement pstmt = conn.prepareStatement(sql);

		return rowCnt;
	}

}
