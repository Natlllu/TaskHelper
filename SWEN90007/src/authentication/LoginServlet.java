package authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.UserMapper;


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
		
		boolean result = login.findUser(email, password);
		//System.out.print(result);
		if(result==true) {
//			request.setAttribute("user_id", login.ExtractUserID(email, password));
			request.getRequestDispatcher("/ViewTasks").forward(request, response);
		}		
		else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
}
