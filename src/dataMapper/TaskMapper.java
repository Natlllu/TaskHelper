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
	private static final String findAvailableTasksbyTaskID =
			"SELECT * from tasks WHERE task_id=?";
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
	
	private static final String findTasksbyExpertID =
			"SELECT * from tasks WHERE expert_id=?";
	public static List<Task> findTasksByExpertId(int expert_id){
		List<Task> result = new ArrayList<>();
		try{
			PreparedStatement stmt  = DBConnection.prepare(findTasksbyExpertID);			
			stmt.setInt(1, expert_id );
			ResultSet rs = stmt.executeQuery();	
			
			while (rs.next()){
	//			System.out.println(rs.getInt(1));
				int task_id = rs.getInt(1);
				int customer_id = rs.getInt(2);
				int expert = expert_id;
				String task_name = rs.getString(4);
				Timestamp task_time = rs.getTimestamp(5);
				String location = rs.getString(6);
				String contact = rs.getString(7);
				String task_description = rs.getString(8);
				float budget = rs.getFloat(9);
				int task_status = rs.getInt(10);
				result.add(new Task(task_id, customer_id, expert, task_name, task_time,
						location, contact, task_description, budget, task_status));
							
			}}catch(SQLException e){
				
			}
			return result;
	}
	
	
	
	public static List<Task> findTasksbyTaskID(int task_id){
		List<Task> result = new ArrayList<>();
		try{
			PreparedStatement stmt  = DBConnection.prepare(findAvailableTasksbyTaskID);
			
			stmt.setInt(1, task_id );
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()){
	//			System.out.println(rs.getInt(1));
				//int task_id = rs.getInt(1);
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
	
	
	private static final String cancelTaskStatement = 
			"UPDATE tasks SET task_status=0,expert_id=NULL"   //2 is finished task but no confirmation.
					+ " WHERE task_id=?;";
	public static void cancelTask(int task_id){
		try{
			PreparedStatement stmt  = DBConnection.prepare(cancelTaskStatement);
			
			stmt.setInt(1, task_id);
			stmt.executeQuery();
			
			}catch(SQLException e){
				
			}
		
	}
	
	
	
	private static final String insertTaskStatement = 
			"INSERT INTO tasks (task_name,customer_id,task_time,location,contact,task_description,budget,task_status) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
	
	public static void insertTask(String task_name, int customer_id, Timestamp task_time, String location, String contact, String task_description, float budget) {
		try {
			PreparedStatement stmt = DBConnection.prepare(insertTaskStatement);
			stmt.setString(1, task_name);
			stmt.setInt(2, customer_id);
			stmt.setTimestamp(3, task_time);
			stmt.setString(4, location);
			stmt.setString(5, contact);
			stmt.setString(6, task_description);
			stmt.setFloat(7, budget);	
			stmt.setInt(8, 0);
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			
		}
	}
	
	
	private static final String changeTaskStatusStatement = 
			"UPDATE tasks SET task_status=1,expert_id=?"
					+ " WHERE task_id=?;";
	
	public static void changeTaskStatus(int task_id, int expert_id) {
		try {
			PreparedStatement stmt = DBConnection.prepare(changeTaskStatusStatement);
			stmt.setInt(1, expert_id);
			stmt.setInt(2, task_id);
			stmt.executeUpdate();		
		}catch(SQLException e) {
			
		}
	}
	
	
	private static final String changeTaskStatusToFinishStatement = 
			"UPDATE tasks SET task_status=2"   //2 is finished task but no confirmation.
					+ " WHERE task_id=?;";
	
	public static void changeTaskStatusToFinish(int task_id) {
		try {
			PreparedStatement stmt = DBConnection.prepare(changeTaskStatusToFinishStatement);
		
			stmt.setInt(1, task_id);
			stmt.executeUpdate();		
		}catch(SQLException e) {
			
		}
	}
	
	private static final String confirmTaskStatement = 
			"UPDATE tasks SET task_status=3"                 //3 is finished task with confirmation.
			+ " WHERE task_id=?;";
	
	public static void confirmTask(int task_id) {
		try {
			PreparedStatement stmt = DBConnection.prepare(confirmTaskStatement);
			stmt.setInt(1, task_id);
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			
		}
	}
	
	
	
	
	
	private static final String updateTaskStatement = 
			"UPDATE tasks SET task_name=?, task_time=?, location=?, contact=?, task_description=?, budget=?"
			+ " WHERE task_id=?;";
	
	public static void updateTask(String task_name, Timestamp task_time, String location, String contact, String task_description, float budget, int task_id) {
		try {
			PreparedStatement stmt = DBConnection.prepare(updateTaskStatement);
			stmt.setString(1, task_name);
			stmt.setTimestamp(2, task_time);
			stmt.setString(3, location);
			stmt.setString(4, contact);
			stmt.setString(5, task_description);
			stmt.setFloat(6, budget);	
			stmt.setInt(7, task_id);
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			
		}
	}
	

	private static final String findAvailableTasksbyTaskStatus =
			"SELECT * from tasks WHERE task_status=?";
	public static List<Task> taskNotAccepted(int task_st){
		List<Task> result = new ArrayList<>();
		try{
			PreparedStatement stmt  = DBConnection.prepare(findAvailableTasksbyTaskStatus);
			
			stmt.setInt(1, task_st );
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
	

}
