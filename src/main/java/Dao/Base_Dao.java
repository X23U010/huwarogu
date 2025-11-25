package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base_Dao {
	// 接続文字列
	private static final String URL = "jdbc:mysql://localhost:3306/huwarogu";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	// コネクション
	protected Connection con = null;

	// DB接続する
	protected void connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// DB切断する
	protected void disConnect() throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}