<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="taskHelperController.*"%>
<%@page import="security.*"%>
<%@page import="dataMapper.*"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Tasks</title>
</head>
<body>

<h1>My Tasks(You are expert!!!)</h1>
 
 <a href="ExpertMainPage.jsp">Main page</a>			
 
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
    	<th>Finish</th>
    	<th>Cancel</th>
 	</tr>
 		
<%-- <p> This is <%=AppSession.getUser().getUser_id()%>   of user_id !!(Your are expert) </p> 	 --%>
 	<%
	int userId=AppSession.getUser().getUser_id();  				
	List<Task> tasks=TaskMapper.findTasksByExpertId(userId);	

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
 	     <%if(task.getTask_status()==1) {%>
 	
<th>
 		<form action = "ExpertsFinishTask" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="Finish" formaction="ExpertsFinishTask">Finish</button>
        </form>	    	 
 	</th>
<%
		}
		
%>

  <%if(task.getTask_status()==1) {%>
 	
<th>
 		<form action = "ExpertsCancelTask" method="post">
    	<button value="<%=task.getTask_id()%>" type="submit" name="Cancel" formaction="ExpertsCancelTask">Cancel</button>
        </form>	    	 
 	</th>
<%
		}
		
%>


 	</tr>


<%
		}
		
%>

</body>
</html>