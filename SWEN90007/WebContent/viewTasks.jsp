<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dataMapper.TaskMapper" %>  
<%@ page import="model.Task" %>  
<%@ page import="dataMapper.UserMapper" %> 
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
List<Task> tasks = new ArrayList<Task>();
String email = request.getParameter("email");
String password  = request.getParameter("password");	
int user_id = UserMapper.ExtractUserID(email, password);	
tasks = TaskMapper.findTasks(user_id);	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View My Tasks</title>
</head>
<body>


		<div class='container'>
		
		<h1>View Tasks</h1>
		<form  method="post">
		<input type="hidden" name="email" value="" + email + "" />
		<input type="hidden" name="password" value="" + password + "" />
		<tr><td><button type="submit" name="addTask" value="" +
					user_id + "" formaction="../SendID" class="btn btn-default">Add Task</button></td></tr>	
		</form>
		
		
		
		
		<table class='table table-bordered table-striped'>
		<tr><th>Task</th><th>Time</th><th>Location</th><th>Budget</th><th>Details</th><th>Delete</th>
		
<% 


for (Task task : tasks) {
	out.println("<form  method=\"post\">");
	out.println("<input type=\"hidden\" name=\"email\" value=\"" + email + "\" />");
	out.println("<input type=\"hidden\" name=\"password\" value=\"" + password + "\" />");
	out.println("<input type=\"hidden\" name=\"task_id\" value=\"" + task.getTask_id() + "\" />");
	out.println("<input type=\"hidden\" name=\"task_name\" value=\"" + task.getTask_name() + "\" />");
	out.println("<input type=\"hidden\" name=\"expert_id\" value=\"" + task.getExpert_id() + "\" />");
	out.println("<input type=\"hidden\" name=\"task_time\" value=\"" + task.getTask_time() + "\" />");
	out.println("<input type=\"hidden\" name=\"location\" value=\"" + task.getLocation() + "\" />");
	out.println("<input type=\"hidden\" name=\"contact\" value=\"" + task.getContact() + "\" />");
	out.println("<input type=\"hidden\" name=\"task_description\" value=\"" + task.getTask_description() + "\" />");
	out.println("<input type=\"hidden\" name=\"budget\" value=\"" + task.getTask_budget() + "\" />");
	out.println("<input type=\"hidden\" name=\"task_status\" value=\"" + task.getTask_status() + "\" />");
	out.print("<tr><td>" + task.getTask_name() + "</td><td>" + task.getTask_time() +
			"</td><td>" +task.getLocation() + "</td><td>" + task.getTask_budget() +
			"</td>" +
			"<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"Details\" formaction=\"/ViewDetails\" class=\"btn btn-default\">View Details</button></td>" +
			"<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"Delete\" value=\"" +
			task.getTask_id() + "\" formaction=\"../DeleteTask\" class=\"btn btn-default\">Delete Task</button></td></tr>");
	
	out.println("</form>");
}

%>
		
		

		
		</table>



</body>
</html>