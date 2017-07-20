package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public static Connection conn = null;
	public static PreparedStatement pst = null;
	public static ResultSet rs = null;
	
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "login";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String userName = "root";
	public static String password = "root";
	
	public void connect()
	{		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			//System.out.println("Connection Successful");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}