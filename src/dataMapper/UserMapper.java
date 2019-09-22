package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.User;


public class UserMapper {
	private static final String findUserStatement = 
			"SELECT * from users WHERE email=? and password=?";
	public boolean findUser(String email, String password) {
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
	
	private static final String findEmailStatement = 
			"SELECT * from users WHERE email=?";
	public static boolean alreadyExistEmail(String email) {
		boolean m=false;
		try {
			PreparedStatement stmt = DBConnection.prepare(findEmailStatement);
			stmt.setString(1, email);
			//stmt.setString(2, password);
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
	
	
	private static final String findExpertNameStatement = 
			"SELECT * from users WHERE id=?";
	public static String ExtractUserName(int user_id) {
		String user_name = null;
		try {
			PreparedStatement stmt = DBConnection.prepare(findExpertNameStatement);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();		
			if(rs.next()){
				user_name = rs.getString("user_name");
			}else{
				user_name = "00000";
			}		    
	}catch(SQLException e) {		
		}
		System.out.println(user_name);
		return user_name;
	}
	
	
	
	
	
	
	
	public static User ExtractUserObject(String email, String password) {
		User user = null;
		try {
			PreparedStatement stmt = DBConnection.prepare(findUserStatement);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();		
			if(rs.next()){
				int user_ID = rs.getInt("id");
				String contact = rs.getString("user_contact");
				int user_type = rs.getInt("user_type");
				String user_name = rs.getString("user_name");
				user = new User(user_ID, email, password, user_name, contact, user_type);
				
			}else{
				
			}		
		}catch(SQLException e) {
		
		}
		return user;
	}
	
	public static int ExtractUserID(String email, String password) {
		int user_ID = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(findUserStatement);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();		
			if(rs.next()){
				user_ID = rs.getInt("id");
			}else{
				user_ID = 0;
			}		
		}catch(SQLException e) {
		
		}
		return user_ID;
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
