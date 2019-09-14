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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Task> tasks = new ArrayList<Task>();
		
//		int user_id = Integer.parseInt(request.getParameter("user_id"));
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
		out.print("<button onclick = \"window.location.href = 'http://localhost:8080/SWEN90007/addTask.jsp'\">Add New Task</button>");
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Task</th><th>Time</th><th>Location</th><th>Budget</th><th>Details</th><th>Delete</th>");
		
		for (Task task : tasks) {
			out.println("<form  method=\"post\">");
			out.print("<tr><td>" + task.getTask_name() + "</td><td>" + task.getTask_time() +
					"</td><td>" +task.getLocation() + "</td><td>" + task.getTask_budget() +
					"</td>" +
					"<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"Details\" value=\"" +
					task.getTask_name() + "\" formaction=\"../Details\" class=\"btn btn-default\">View Details</button></td>" +
					"<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"Delete\" value=\"" +
					task.getTask_id() + "\" formaction=\"../DeleteTask\" class=\"btn btn-default\">Delete Task</button></td></tr>");
			
			out.println("</form>");
		}
		
		out.println("</table>");
		out.println("</div>");
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
