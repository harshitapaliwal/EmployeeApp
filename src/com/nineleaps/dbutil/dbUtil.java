package com.nineleaps.dbutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbUtil {
	static Connection conn = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@DESKTOP-BM1A64V:1521:XE";
		String username= "system";
		String password="system";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,username,password);
		
		return conn;

	}

}
