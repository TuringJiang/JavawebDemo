package dbutil;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.jdbc.Connection;

import javabean.User;

public class DbUtil {

	private static String url = "jdbc:mysql://localhost:3306/Test?user=root&password=123456&useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static java.sql.PreparedStatement pst;
	private static String sql = "select * from student;";

	public static void main(String[] args) {
		List<User> userlist = new ArrayList<User>();
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url);
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User userstudent = new User();
				userstudent.setNumber(rs.getString("number"));
				userstudent.setName(rs.getString("name"));
				userstudent.setBeizhu(rs.getString("beizhu"));
				userstudent.setSex(rs.getString("sex"));

				userlist.add(userstudent);
			}
			Iterator<User> it = userlist.iterator();
			while (it.hasNext()) {
				User user = it.next();
				System.out.println(
						user.getNumber() + " " + user.getName() + " " + user.getSex() + " " + user.getBeizhu());
			}
			rs.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
