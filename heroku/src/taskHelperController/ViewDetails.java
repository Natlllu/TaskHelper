package taskHelperController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import dataMapper.TaskMapper;
import model.Task;

/**
 * Servlet implementation class ViewDetails
 */
@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	//	Subject currentUser=SecurityUtils.getSubject();


		
		int task_id = Integer.parseInt(request.getParameter("View"));
		List<Task> tasks=TaskMapper.findTasksbyTaskID(task_id);	
		
		
		for(Task task:tasks){
			
			String task_name=task.getTask_name();
			Timestamp task_time = task.getTask_time();
			String location =task.getLocation();
			String contact = task.getContact();
			String task_status = task.getTask_statueByString();
			String task_description=task.getTask_description();
			float budget = task.getTask_budget();
			
			request.setAttribute("task_name", task_name);
			//request.setAttribute("expert_id", expert_id);
			request.setAttribute("task_time", task_time);
			request.setAttribute("location", location);
			request.setAttribute("contact", contact);
			request.setAttribute("task_description", task_description);
			request.setAttribute("budget", budget);
			request.setAttribute("task_status", task_status);
			request.getRequestDispatcher("../taskDetails.jsp").forward(request, response);
			
			
		}
			
	
	//	String email = request.getParameter("email");
	//	String password = request.getParameter("password");	
	//	String task_name = request.getParameter("task_name");
	//	String expert_id = request.getParameter("expert_id");
	//	String task_time = request.getParameter("task_time");
		//String location = request.getParameter("location");
		//String contact = request.getParameter("contact");
		//String task_description = request.getParameter("task_description");
		//float budget = Float.parseFloat(request.getParameter("budget"));
		//String task_status = request.getParameter("task_status");
		
		
	//	request.setAttribute("task_id", task_id);
	//	request.setAttribute("email", email);
	//	request.setAttribute("password", password);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
