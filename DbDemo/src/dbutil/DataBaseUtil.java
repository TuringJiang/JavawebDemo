package dbutil;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
	private static String url = "jdbc:mysql://localhost:3306/Test?user=root&password=123456&useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static String driver = "com.mysql.jdbc.Driver";
	private static java.sql.Connection conn = null;

	public static java.sql.Connection getConnection() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConn() throws SQLException {
		conn.close();
	}
}
