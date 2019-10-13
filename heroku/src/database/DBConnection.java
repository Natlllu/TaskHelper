package database;

import java.sql.*;


public class DBConnection {
	
//	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/taskhelper";
//	private static final String DB_USER = "postgres";
//	private static final String DB_PASSWORD = "123456";
	
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-184-73-232-93.compute-1.amazonaws.com:5432/deie6leb2r99i3";
	private static final String DB_USER = "zarrruynvvqdla";
	private static final String DB_PASSWORD = "daba36a40abf811b01599359c31754cdca92726547c5ddb6a25a267c9640e647";
	
	public static Connection dbConnection = null;
	
	public static PreparedStatement prepare(String stm) throws SQLException {
		PreparedStatement preparedStatement = null;
		try{
			Connection dbConnection = getDBConnection();
//			dbConnection.setAutoCommit(true);
//			preparedStatement = dbConnection.prepareStatement(stm, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement = dbConnection.prepareStatement(stm);
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return preparedStatement;
	}
	
	private static Connection getDBConnection(){
		try{
			DriverManager.registerDriver(new org.postgresql.Driver());
			
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			dbConnection.setAutoCommit(true);
			
//			dbConnection.setAutoCommit(false);
			
			
			return dbConnection;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Connection problem");
		return null;
		
	}

}
