package customerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.TaskMapper;
import dataMapper.UserMapper;
import model.Task;

/**
 * Servlet implementation class ViewTasks
 */
@WebServlet("/ViewTasks")
public class ViewTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTasks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Task> tasks = new ArrayList<Task>();
		String email = request.getParameter("email");
		String password  = request.getParameter("password");	
		int user_id = UserMapper.ExtractUserID(email, password);	
		tasks = TaskMapper.findTasks(user_id);	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Tasks</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		
		out.print("<h1>View Tasks</h1>");
		out.println("<form  method=\"post\">");
		out.println("<input type=\"hidden\" name=\"email\" value=\"" + email + "\" />");
		out.println("<input type=\"hidden\" name=\"password\" value=\"" + password + "\" />");
		out.println("<tr><td><button type=\"submit\" name=\"addTask\" value=\"" +
					user_id + "\" formaction=\"../customerService/SendID\" class=\"btn btn-default\">Add Task</button></td></tr>");
		
		out.println("</form>");
				
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Task</th><th>Time</th><th>Location</th><th>Budget</th><th>TaskStatus</th><th>Details</th><th>Delete</th></tr>");
		
		for (Task task : tasks) {
			String status = "";
			if (task.getTask_status() == 0){
				status = "unaccepted";
			}else if(task.getTask_status() == 1){
				status = "accepted and processing";
			}else if(task.getTask_status() == 2){
				status = "finished and to be confirmed";
			}else if(task.getTask_status() == 3){
				status = "finished and closed";
			}
			out.println("<form  method=\"post\">");
			out.println("<input type=\"hidden\" name=\"email\" value=\"" + email + "\" />");
			out.println("<input type=\"hidden\" name=\"password\" value=\"" + password + "\" />");
			out.println("<input type=\"hidden\" name=\"task_id\" value=\"" + task.getTask_id() + "\" />");
			out.println("<input type=\"hidden\" name=\"task_name\" value=\"" + task.getTask_name() + "\" />");
			out.println("<input type=\"hidden\" name=\"expert_id\" value=\"" + task.getExpert_id() + "\" />");
			out.println("<input type=\"hidden\" name=\"task_time\" value=\"" + task.getTask_time() + "\" />");
			out.println("<input type=\"hidden\" name=\"location\" value=\"" + task.getLocation() + "\" />");
			out.println("<input type=\"hidden\" name=\"contact\" value=\"" + task.getContact() + "\" />");
			out.println("<input type=\"hidden\" name=\"task_description\" value=\"" + task.getTask_description() + "\" />");
			out.println("<input type=\"hidden\" name=\"budget\" value=\"" + task.getTask_budget() + "\" />");
			out.println("<input type=\"hidden\" name=\"task_status\" value=\"" + task.getTask_status() + "\" />");
			out.print("<tr><td>" + task.getTask_name() + "</td><td>" + task.getTask_time() +
					"</td><td>" +task.getLocation() + "</td><td>" + task.getTask_budget() +
					"</td><td>" + status + "</td>" +
					"<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"Details\" formaction=\"../customerService/ViewDetails\" class=\"btn btn-default\">View Details</button></td>");
			
			if(status == "unaccepted"){
					out.print("<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"Delete\" value=\"" +
					task.getTask_id() + "\" formaction=\"../customerService/DeleteTask\" class=\"btn btn-default\">Delete Task</button></td></tr>");
			}else{
				
			}
			out.println("</form>");
		}
		
		out.println("</table>");
		out.println("</div>");
		out.println("<form  method=\"post\">");
		out.println("<tr><td><button type=\"submit\" name=\"logout\" value=\"" +
					user_id + "\" formaction=\"../LogoutServlet\" class=\"btn btn-default\">Logout</button></td></tr>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
