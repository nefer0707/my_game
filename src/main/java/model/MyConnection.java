package model;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MyConnection {
	public static Connection con;
	public static Connection getMyConnection() throws Exception {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/MyGame");
		return con = ds.getConnection();
	}
	
}
