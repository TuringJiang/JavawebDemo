package dbutil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.User;

public class oracleUtil {

	private static String url = "jdbc:oracle:thin:@211.82.169.249:1521:orcl";
	private static java.sql.PreparedStatement pst;
	private static String username = "ysrgsj";
	private static String password = "123456";

	public static void main(String[] args) {
		Connection conn = null;
		System.out.println("第一步。");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("第二步。");
			conn = (Connection) DriverManager.getConnection(url, username, password);
			CallableStatement proc = null;
			proc = (CallableStatement) conn.prepareCall("{call ysrgsj.checkout_login_password(?,?)}");
			proc.setString(1, "952622946@qq.com");
			proc.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			proc.execute();
			String testhaha = proc.getString(2);
			System.out.println("测试数据：" + testhaha);
			System.out.println("第三步。");
			proc.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
