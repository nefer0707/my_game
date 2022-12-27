package model;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MyConnection {
	public static Connection con;
	public static Connection getMyConnection() throws Exception {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/MyGame");
		return con = ds.getConnection();
	}
	
}
