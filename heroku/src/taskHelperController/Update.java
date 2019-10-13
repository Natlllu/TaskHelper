package taskHelperController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.TaskMapper;
import model.Task;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int task_id = Integer.parseInt(request.getParameter("Update"));
		
List<Task> tasks=TaskMapper.findTasksbyTaskID(task_id);	
		
		for(Task task:tasks){
			
			String task_name=task.getTask_name();
			Timestamp task_time = task.getTask_time();
			String location =task.getLocation();
			String contact = task.getContact();
			String task_description=task.getTask_description();
			String task_status = task.getTask_statueByString();
			float budget = task.getTask_budget();
			
			request.setAttribute("task_id", task_id);

			request.setAttribute("task_name", task_name);
			request.setAttribute("task_time", task_time);
			request.setAttribute("location", location);
			request.setAttribute("contact", contact);
			request.setAttribute("task_description", task_description);
			request.setAttribute("budget", budget);
			request.setAttribute("task_status", task_status);
			request.getRequestDispatcher("../updateTask.jsp").forward(request, response);
			
			
		}
		
	}

}
