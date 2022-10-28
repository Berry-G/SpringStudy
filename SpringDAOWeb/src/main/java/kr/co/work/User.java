package kr.co.work;

import java.util.Date;
import java.util.Objects;

public class User
{
	String user_id;
	String user_pw;
	String user_name;
	String user_email;
	Date user_birth;
	String user_sns;
	Date user_create_date;
	public User(String user_id, String user_pw, String user_name, String user_email, Date user_birth, String user_sns,
			Date user_create_date)
	{
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_birth = user_birth;
		this.user_sns = user_sns;
		this.user_create_date = user_create_date;
	}
	
	public User()
	{
		// TODO Auto-generated constructor stub
	}
	
	public String getUser_id()
	{
		return user_id;
	}
	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}
	public String getUser_pw()
	{
		return user_pw;
	}
	public void setUser_pw(String user_pw)
	{
		this.user_pw = user_pw;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}
	public String getUser_email()
	{
		return user_email;
	}
	public void setUser_email(String user_email)
	{
		this.user_email = user_email;
	}
	public Date getUser_birth()
	{
		return user_birth;
	}
	public void setUser_birth(Date user_birth)
	{
		this.user_birth = user_birth;
	}
	public String getUser_sns()
	{
		return user_sns;
	}
	public void setUser_sns(String user_sns)
	{
		this.user_sns = user_sns;
	}
	public Date getUser_create_date()
	{
		return user_create_date;
	}
	public void setUser_create_date(Date user_create_date)
	{
		this.user_create_date = user_create_date;
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(user_birth, user_create_date, user_email, user_id, user_name, user_pw, user_sns);
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(user_birth, other.user_birth) && Objects.equals(user_create_date, other.user_create_date)
				&& Objects.equals(user_email, other.user_email) && Objects.equals(user_id, other.user_id)
				&& Objects.equals(user_name, other.user_name) && Objects.equals(user_pw, other.user_pw)
				&& Objects.equals(user_sns, other.user_sns);
	}
	
	
	
}
