package taskHelperController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataMapper.UserMapper;
import model.*;


public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String password  = request.getParameter("password");
		UserMapper login = new UserMapper();
		
		Session.refreshSession(request.getSession());
		

		boolean result = login.findUser(email, password);
		

		if(result==true) {
			int user_id = UserMapper.ExtractUserID(email, password);
			User user_type=UserMapper.ExtractUserObject(email, password);
			if (user_type.get_user_type()==0) {// 0 is customer
				HttpSession session=request.getSession();
                session.setAttribute("userId",user_id);
			    request.getRequestDispatcher("/ViewTasks.jsp").forward(request, response);
			}
		    else {
		    	HttpSession session=request.getSession();
			    	session.setAttribute("userId",user_id);
				    request.getRequestDispatcher("/ExpertMainPage.jsp").forward(request, response);
			    }
			   }		
		else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
}
