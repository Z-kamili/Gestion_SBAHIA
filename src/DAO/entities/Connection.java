package DAO.entities;

import java.sql.DriverManager;

public class Connection {
	
	private static java.sql.Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Manage_Products","postgres","Te$t1520");
			System.out.println("Connect");
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	
		
		
	}

	public static java.sql.Connection getConnection() {
		return connection;
	}

	public static void setConnection(java.sql.Connection connection) {
		Connection.connection = connection;
	}
	
	

}
