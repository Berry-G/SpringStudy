package kr.co.work;

public interface UserDAO
{

	User selectUser(String id);

	void deleteAll() throws Exception;
	int updateUser(User user);
	int insertUser(User user);

}