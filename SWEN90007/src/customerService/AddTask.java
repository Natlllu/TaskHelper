package customerService;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.TaskMapper;

/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTask() {
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
		
		
//		java.sql.Date task_date = null;
//		try {
//			task_date = (Date) new  SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("task_date"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				;
		String  task_name  = request.getParameter("task_name");
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//	    Date parsedDate = null;
//		try {
//			parsedDate = (Date) dateFormat.parse(request.getParameter("task_time"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    Timestamp task_time = new java.sql.Timestamp(parsedDate.getTime());
		
		
//		Timestamp task_time = Timestamp.parseTimestamp(request.getParameter("task_time"));
		
//		String input = "2007-11-11 12:13:14" ;
		java.sql.Timestamp task_time = java.sql.Timestamp.valueOf( request.getParameter("task_time") ) ;
		
		String location  = request.getParameter("location");
		String contact  = request.getParameter("contact");		
		String task_description  = request.getParameter("task_description");
		Float budget=Float.parseFloat(request.getParameter("budget"));
		TaskMapper.insertTask(task_name, customer_id, task_time ,location, contact,task_description,budget);
		System.out.println("success");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);
		

		request.setAttribute("email", email);
		request.setAttribute("password", password);
		

	    request.getRequestDispatcher("/authentication/LoginServlet").forward(request, response);
	    response.sendRedirect("/authentication/LoginServlet");
//		response.sendRedirect("/products");
	}

}
