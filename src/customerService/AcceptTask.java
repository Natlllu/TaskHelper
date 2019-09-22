package customerService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.TaskMapper;
import model.Task;

/**
 * Servlet implementation class AcceptTask
 */
@WebServlet("/AcceptTask")
public class AcceptTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		

		int task_id = Integer.parseInt(request.getParameter("taskId"));
		//ServletRequest session= null;
		int expert_id = Integer.parseInt(request.getParameter("userId"));
		//int expert_id=(int)session.getAttribute("userId");  	
		System.out.println("task id is "+task_id);
		System.out.println("expert id is "+expert_id);	
		TaskMapper.changeTaskStatus(task_id, expert_id);	
		
		request.getRequestDispatcher("/ViewTasksForExpert.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
