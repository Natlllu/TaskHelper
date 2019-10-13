<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="dataMapper.*"%>
<%@page import="taskHelperController.*"%>
<%@page import="security.*"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Tasks</title>
</head>
<body>

<h1>View Tasks</h1>
You are already logged in as <%=AppSession.getUser().get_email() %>
 	<%-- <p> This is <%=AppSession.getUser().getUser_id() %>   of user_id !! </p> --%>
<%System.out.println("hello word"); %>
 <a href="ViewTasks.jsp">refresh</a>			

 <a href="../addTask.jsp"> ADD New Tasks</a>
 
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
    	<th>Update</th>
    	<th>Operations</th>
 	</tr>
 	
 	

 	
 	<%
	int userId=AppSession.getUser().getUser_id();  				
	List<Task> tasks=TaskMapper.findTasks(userId);	

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
 	
 	    <%if(task.getTask_status()==0) {%>
 	    
 	    
 	    <form action = "Update" method="post">
<button value="<%=task.getTask_id()%>" type="submit" name="Update" formaction="Update">Update</button>    	

</form>
    	
    	<%} %>
 
 	</th>
 	
 	
 	
 	<% int id=task.getExpert_id();	
 	UserMapper user; 	   
 	%>
 	<%if(task.getTask_status()==0) {%>
              <th>
    	<form action = "DeleteTask" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="Delete" formaction="DeleteTask">Delete</button>
             </form>	    
             </th>	
             
             <% } %> 
             
             <%if(task.getTask_status()==1) {%>
              <th>
    	    Doing by <%=UserMapper.ExtractUserName(id)%>
             </th>	
             
             <% } %> 
             
             <%if(task.getTask_status()==2) {%>
              <th>
    	<form action = "taskHelperController/ConfirmTask" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="Confirm" formaction="taskHelperController/ConfirmTask">Confirm</button>
             </form>	    
             </th>	
             
             <% } %> 
             
              <%if(task.getTask_status()==3) {%>
              <th>
    	           Done
             </th>	
             
             <% } %> 
             
             
 	</tr>


<%
		}
		
%>

</body>
</html>