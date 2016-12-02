package userdao.userdaoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dbutil.DataBaseUtil;
import javabean.User;
import userdao.UserDaoImpl;

public class UserDao implements UserDaoImpl {

	private User user = new User();
	private List<User> userlist = new ArrayList<User>();

	private PreparedStatement pst = null;

	private String sql = "";

	public PreparedStatement init(String sql) {
		try {
			pst = (PreparedStatement) DataBaseUtil.getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pst;
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		// 在register相同
		return false;
	}

	public boolean delectUser(String number) {
		// TODO Auto-generated method stub
		sql = "delete from student where number='" + number + "'";
		System.out.println("sql:" + sql);
		boolean result = false;
		try {
			PreparedStatement pst = init(sql);
			result = pst.execute();
			pst.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				DataBaseUtil.closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		sql = "update student set name='" + user.getName() + "',sex='" + user.getSex() + "',beizhu='" + user.getBeizhu()
				+ "' where number='" + user.getNumber() + "'";
		PreparedStatement pst = init(sql);
		try {
			pst.execute();
			pst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DataBaseUtil.closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	public List<User> selectUser() {
		// TODO Auto-generated method stub
		sql = "select * from student";
		PreparedStatement pst = init(sql);
		try {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User adduser = new User();
				adduser.setNumber(rs.getString("number"));
				adduser.setName(rs.getString("name"));
				adduser.setBeizhu(rs.getString("beizhu"));
				adduser.setSex(rs.getString("sex"));

				userlist.add(adduser);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DataBaseUtil.closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userlist;
	}

	public boolean register(User user) {
		// TODO Auto-generated method stub
		sql = "insert into student(number,name,sex,beizhu) values(?,?,?,?);";
		try {
			PreparedStatement pst = init(sql);
			pst.setString(1, user.getNumber());
			pst.setString(2, user.getName());
			pst.setString(3, user.getSex());
			pst.setString(4, user.getBeizhu());
			pst.executeUpdate();
			pst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.getConnection();
		}
		return false;
	}

	public int login(String number, String name) {
		// TODO Auto-generated method stub
		sql = "select number,name from student where number='" + number + "'";
		System.out.println("sql:" + sql);
		PreparedStatement pst = init(sql);
		int haha = -1;
		try {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if (rs.getString("name").equals(name)) {
					System.out.println("数据比对成功，可以登陆。");
					haha = 1;
					rs.close();
					pst.close();
					return haha;
				} else {
					System.out.println("数据比对失败，正在退出，返回。");
					System.out.println("登录失败，密码错误。");
					haha = 0;
					rs.close();
					pst.close();
					return haha;
				}
			}
			System.out.println("登录失败，Number错误。");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("抱歉，登陆失败，取数据异常。");
			e.printStackTrace();
		} finally {
			try {
				DataBaseUtil.closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return haha;
	}

	public User findUserByNumber(String number) {
		// TODO Auto-generated method stub
		sql = "select * from student where number='" + number + "'";
		System.out.println("sql：" + sql);
		PreparedStatement pst = init(sql);
		try {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setNumber(rs.getString("number"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setBeizhu(rs.getString("beizhu"));
				rs.close();
				pst.close();
				System.out.println("用户已找到：" + user.getNumber());
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DataBaseUtil.closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

}
