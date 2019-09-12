package dataMapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import database.DBConnection;
import model.Task;

public class TaskMapper {
	private static final String findAvailableTasks =
			"SELECT * from tasks";
	
	public static List<Task> findTasks(){
		List<Task> result = new ArrayList<>();
		try{
			PreparedStatement stmt  = DBConnection.prepare(findAvailableTasks);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
	//			System.out.println(rs.getInt(1));
				int task_id = rs.getInt(1);
				int customer_id = rs.getInt(2);
				int expert_id = rs.getInt(3);
				String task_name = rs.getString(4);
				Date task_date = rs.getDate(5);
				Time task_time = rs.getTime(6);
				String location = rs.getString(7);
				String contact = rs.getString(8);
				String task_description = rs.getString(9);
				float budget = rs.getFloat(10);
				int task_status = rs.getInt(11);
				result.add(new Task(task_id, customer_id, expert_id, task_name, task_date, task_time,
						location, contact, task_description, budget, task_status));
				
				
			}}catch(SQLException e){
				
			}
			return result;
	}

}
