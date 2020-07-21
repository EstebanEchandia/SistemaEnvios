package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private static final String url ="jdbc:postgresql:tpdied.cquiwsbyjbxy.sa-east-1.rds.amazonaws.com";
	private static final String user="root";
	private static final String pass="trabajopracticodied";

	private DB(){
	}

	public static Connection get(){
		Connection conn=null;
		try {
			
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
