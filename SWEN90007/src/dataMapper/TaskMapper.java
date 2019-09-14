package dataMapper;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import database.DBConnection;
import model.Task;

public class TaskMapper {
	private static final String findAvailableTasks =
			"SELECT * from tasks WHERE customer_id=?";
	private static final String deleteTask =
			"DELETE FROM tasks WHERE task_id=? ;";
	
	public static List<Task> findTasks(int user_id){
		List<Task> result = new ArrayList<>();
		try{
			PreparedStatement stmt  = DBConnection.prepare(findAvailableTasks);
			
			stmt.setInt(1, user_id );
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()){
	//			System.out.println(rs.getInt(1));
				int task_id = rs.getInt(1);
				int customer_id = rs.getInt(2);
				int expert_id = rs.getInt(3);
				String task_name = rs.getString(4);
				Timestamp task_time = rs.getTimestamp(5);
				String location = rs.getString(6);
				String contact = rs.getString(7);
				String task_description = rs.getString(8);
				float budget = rs.getFloat(9);
				int task_status = rs.getInt(10);
				result.add(new Task(task_id, customer_id, expert_id, task_name, task_time,
						location, contact, task_description, budget, task_status));
				
				
			}}catch(SQLException e){
				
			}
			return result;
	}
	
	public static void deleteTask(int task_id){
		try{
			PreparedStatement stmt  = DBConnection.prepare(deleteTask);
			
			stmt.setInt(1, task_id);
			stmt.executeQuery();
			
			}catch(SQLException e){
				
			}
		
	}
	
	private static final String insertUserStatement = 
			"INSERT INTO tasks (task_name,task_time,location,contact,task_description,budget) VALUES (?, ?, ?, ?, ?, ?);";
	
	public static void insertTask(String task_name, Timestamp task_time, String location, String contact, String task_description, float budget) {
		try {
			PreparedStatement stmt = DBConnection.prepare(insertUserStatement);
			stmt.setString(1, task_name);			
			stmt.setTimestamp(2, task_time);
			stmt.setString(3, location);
			stmt.setString(4, contact);
			stmt.setString(5, task_description);
			stmt.setFloat(6, budget);						
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			
		}
	}

}
