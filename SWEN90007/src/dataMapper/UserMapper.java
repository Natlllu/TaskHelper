package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;


public class UserMapper {
	private static final String findUserStatement = 
			"SELECT * from users WHERE email=? and password=?";
	public boolean findCustomer(String email, String password) {
		boolean m=false;
		try {
			PreparedStatement stmt = DBConnection.prepare(findUserStatement);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();		
			if(rs.next()){
				m=true;
			}else{
				m=false;
			}		
		}catch(SQLException e) {
		
		}
		return m;
	}
	
	private static final String insertUserStatement = 
			"INSERT INTO users (user_name, password, email, user_contact, user_type) VALUES (?, ?, ?, ?, ?);";
	
	public void insertUser(String name, String password, String email, String user_contact, int user_type) {
		try {
//			System.out.println("start");
			PreparedStatement stmt = DBConnection.prepare(insertUserStatement);
			stmt.setString(1, name);
			stmt.setString(2, password);			
			stmt.setString(3, email);
			stmt.setString(4, user_contact);
			stmt.setInt(5, user_type);
			stmt.executeUpdate();
//			int result = stmt.executeUpdate();
//			System.out.println(result);
		}catch(SQLException e) {
			
		}
	}

}
