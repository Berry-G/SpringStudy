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
public class UserDAO implements UserDAOImpl
{
	@Autowired
	DataSource ds;
	
	@Override
	public User selectUser(String id)
	{
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "selelct * from t_user where id = ? ";
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
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
		}
		catch (SQLException e) {
			return null;
		}
		finally {
			if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace();}}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace();}}
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace();}}
		}
		
		return user;		
	}

}
