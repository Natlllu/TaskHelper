package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import model.*;
import security.AppSession;


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
		UsernamePasswordToken token = new UsernamePasswordToken(email,password);
		token.setRememberMe(true);
		
		Subject currentUser=SecurityUtils.getSubject();
		String view="/login.jsp";
		
		try {
			
			currentUser.login(token);
			
			User user = User.getUser(email);
			AppSession.init(user);
			if(user.get_user_type()==0) {
				view="/ViewTasks.jsp";
			}
			else {
				view="/ExpertMainPage.jsp";
				
			}
			
		} catch(UnknownAccountException | IncorrectCredentialsException e) {
			
			view="/error.jsp";
		}finally {
			ServletContext servletContext=getServletContext();
			RequestDispatcher requestDispatcher=servletContext.getRequestDispatcher(view);
			requestDispatcher.forward(request,response);
		}
		

		//boolean result = login.findUser(email, password);
		
/*
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
	
	*/
}
}
