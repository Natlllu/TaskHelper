package taskHelperController;
import model.*;
import security.AppSession;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataMapper.LockManager;
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
		//HttpSession session=request.getSession();
		//int userId=(int)session.getAttribute("userId");
		
	
				User user =AppSession.getUser();
				
				
				
				try {
					LockManager.getInstance().acquireReadLock(user);
				} catch (InterruptedException e) {
					System.out.println("Acquiring write lock when adding a book failed");
				}
				
				int userId = user.getUser_id();
				String  task_name  = request.getParameter("task_name");
				//	int customer_id = Integer.parseInt(request.getParameter("customer_id"));
//					java.util.Date
					java.sql.Timestamp task_time = java.sql.Timestamp.valueOf( request.getParameter("task_time") ) ;
					//task_time.get
					String location  = request.getParameter("location");
					String contact  = request.getParameter("contact");		
					String task_description  = request.getParameter("task_description");
					Float budget=Float.parseFloat(request.getParameter("budget"));
					
					
						TaskMapper.insertTask(task_name, userId, task_time ,location, contact,task_description,budget);
						
						LockManager.getInstance().releaseReadLock(user);
						
						System.out.println("add success");
						
						String email = request.getParameter("email");
						String password = request.getParameter("password");
						
						System.out.println(email);
						System.out.println(password);
						

						request.setAttribute("email", email);
						request.setAttribute("password", password);
						

					    request.getRequestDispatcher("../ViewTasks.jsp").forward(request, response);
					
					
				
			}
			
		

		
		//List<Task> tasks=TaskMapper.findTasks(userId);	
		
//		String  task_name  = request.getParameter("task_name");
//	//	int customer_id = Integer.parseInt(request.getParameter("customer_id"));
////		java.util.Date
//		java.sql.Timestamp task_time = java.sql.Timestamp.valueOf( request.getParameter("task_time") ) ;
//		//task_time.get
//		String location  = request.getParameter("location");
//		String contact  = request.getParameter("contact");		
//		String task_description  = request.getParameter("task_description");
//		Float budget=Float.parseFloat(request.getParameter("budget"));
//		
//		TaskMapper.insertTask(task_name, userId, task_time ,location, contact,task_description,budget);
//		System.out.println("add success");
//		
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		System.out.println(email);
//		System.out.println(password);
//		
//
//		request.setAttribute("email", email);
//		request.setAttribute("password", password);
//		
//
//	    request.getRequestDispatcher("/ViewTasks.jsp").forward(request, response);
	 //   response.sendRedirect("/authentication/LoginServlet");
	}


