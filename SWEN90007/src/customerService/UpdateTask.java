package customerService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.TaskMapper;

/**
 * Servlet implementation class UpdateTask
 */
@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTask() {
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
		doGet(request, response);
		
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		String task_name = request.getParameter("task_name");
		java.sql.Timestamp task_time = java.sql.Timestamp.valueOf( request.getParameter("task_time") ) ;
		String location = request.getParameter("location");
		String contact = request.getParameter("contact");
		String task_description = request.getParameter("task_description");
		float budget = Float.parseFloat(request.getParameter("budget"));
		
		System.out.println(task_name);
		System.out.println(task_id);
		
		
		TaskMapper.updateTask(task_name, task_time, location, contact, task_description, budget, task_id);
		
		
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		

	    request.getRequestDispatcher("/authentication/LoginServlet").forward(request, response);
	}

}
