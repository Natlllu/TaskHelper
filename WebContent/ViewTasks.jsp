<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="dataMapper.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Tasks</title>
</head>
<body>

<h1>View Tasks</h1>
 <a href="/heroku/addTask.jsp"> ADD</a>
 
 			
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
 	
 	
 	<p>This is <%=session.getAttribute("userId")%>   of user_id!! </p>
 	
 	<%
	int userId=(int)session.getAttribute("userId");  				
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
 		<form action = "../customerService/ViewDetails" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="View" formaction="../customerService/ViewDetails">Details</button>
             </form>	    	 
 	</th>
 	
 	<th>
 	
 	    <%if(task.getTask_status()==0) {%>
 	    
 	    
 	    <form action = "../customerService/Update" method="post">
<button value="<%=task.getTask_id()%>" type="submit" name="Update" formaction="../customerService/Update">Update</button>    	

</form>
    	
    	<%} %>
 
 	</th>
 	
 	
 	
 	<% int id=task.getExpert_id();	
 	UserMapper user; 	   
 	%>
 	<%if(task.getTask_status()==0) {%>
              <th>
    	<form action = "../customerService/DeleteTask" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="Delete" formaction="../customerService/DeleteTask">Delete</button>
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
    	<form action = "../customerService/ConfirmTask" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="Confirm" formaction="../customerService/ConfirmTask">Confirm</button>
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