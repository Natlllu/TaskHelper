package taskHelperController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());	
		//HttpSession session=request.getSession();  
        //session.invalidate();  
		//request.logout();
		//request.logout();
		
		//String email = AppSession.getUser().get_email();
		//String password  = AppSession.getUser().get_password();
		//UsernamePasswordToken token = new UsernamePasswordToken(email,password);
		Subject currentUser=SecurityUtils.getSubject();
		currentUser.logout();
		//request.logout();
		//request.getRequestDispatcher("/login.jsp").include(request, response);  
		//request.logout();
//		request.getRequestDispatcher("/login.jsp").include(request, response);  
		response.sendRedirect("https://task-helper.herokuapp.com/"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
