package userdao;

import java.util.List;

import javabean.User;

public interface UserDaoImpl {

	public boolean addUser(User user);

	public boolean delectUser(String number);

	public boolean updateUser(User user);

	public List<User> selectUser();

	public boolean register(User user);

	public int login(String number, String name);

	public User findUserByNumber(String number);

}
