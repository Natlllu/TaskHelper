package authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import dataMapper.UserMapper;



public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("userName");
		String password  = request.getParameter("password");
		String email=request.getParameter("email");
		String user_contact=request.getParameter("user_contact");
		int user_type=Integer.parseInt(request.getParameter("user_type"));
		UserMapper register = new UserMapper();				
		register.insertUser(username, password, email, user_contact, user_type);
		if(user_type==0) {
			request.getRequestDispatcher("/hicustomer.jsp").forward(request, response);
		}
		else
		request.getRequestDispatcher("/HiExpert.jsp").forward(request, response);
	}

}
