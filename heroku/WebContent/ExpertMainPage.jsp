<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="dataMapper.*"%>
<%@page import="taskHelperController.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <p> This is <%=AppSession.getUser().getUser_id()%>   of user_id !!(Your are expert) </p> --%>

<h1>All Tasks from customers</h1>

 <a  href="../ViewTasksForExpert.jsp">My Task</a>
 
  <form action = "LogoutServlet" method="get">
    	<button type="submit" name="View" formaction="LogoutServlet">Logout</button>
        </form>	 
<table>
    <tr>
    	<th>Task</th>
    	<th>Time</th>
    	<th>Location</th>
    	<th>Budget</th>
    	<th>TaskStatus</th>
    	<th>Details</th>
    	<th>Accept</th>
 	</tr>
 	
 	<%
 	
 	List<Task> tasks=TaskMapper.taskNotAccepted(0);	
	for(Task task:tasks){
 	%>
 	
<tr>
    	<th><%=task.getTask_name() %>
    	<th><%=task.getTask_time()%></th>
    	<th><%=task.getLocation() %>
    	<th><%=task.getTask_budget() %>
    	<th><%=task.getTask_statueByString()%></th>
    	<%System.out.println(task.getTask_id()); %>
    	
    	<th>
 		<form action = "ViewDetails" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="View" formaction="ViewDetails">Details</button>
             </form>	    	 
 	</th>
 	
 	
 	<th>
 		<th><a href="taskHelperController/AcceptTask?taskId=<%=task.getTask_id()%>&userId=<%=AppSession.getUser().getUser_id()%>"> Accept</a>
 	</th>
 	
 	
    	
 	<%
		}
		
%>
</table>
</body>
</html>