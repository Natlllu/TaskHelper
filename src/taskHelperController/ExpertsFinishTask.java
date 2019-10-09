package taskHelperController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.TaskMapper;

/**
 * Servlet implementation class ExpertsFinishTask
 */
@WebServlet("/ExpertsFinishTask")
public class ExpertsFinishTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpertsFinishTask() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		

		int task_id = Integer.parseInt(request.getParameter("Finish"));
	
		System.out.println("finished task id is "+task_id);

		TaskMapper.changeTaskStatusToFinish(task_id);		
		request.getRequestDispatcher("/ViewTasksForExpert.jsp").forward(request, response);

	}
}
