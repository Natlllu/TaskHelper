<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
String status = "";
String expert_id = request.getParameter("expert_id");
if (Integer.parseInt(request.getParameter("task_status")) == 0){
	System.out.print(request.getParameter("task_status"));
	status = "unaccepted";
} else if(Integer.parseInt(request.getParameter("task_status")) == 1){
	status = "accepted but not finished";
} else if(Integer.parseInt(request.getParameter("task_status")) == 2){
	status = "waiting to be confirmed";
} else if(Integer.parseInt(request.getParameter("task_status")) == 3){
	status = "finished and confirmed";
} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Details</title>
</head>
<body>
<h3>Task Details</h3>
<%-- <h3> My email is ${email} (just for test)</h3>

<h3> My task_name is ${task_name} (just for test)</h3> --%>
<%-- <h3> My id is ${task_id} (just for test)</h3> --%>

<%
String email = request.getParameter("email");
String password = request.getParameter("password");
int task_id = Integer.parseInt(request.getParameter("task_id"));
if(status == "waiting to be confirmed"){
	out.println("<form  method=\"post\">");
	out.println("<input type=\"hidden\" name=\"email\" value=\"" + email + "\" />");
	out.println("<input type=\"hidden\" name=\"password\" value=\"" + password + "\" />");
	out.println("<input type=\"hidden\" name=\"task_id\" value=\"" + task_id + "\" />");
	out.println("<tr><td><button type=\"submit\" name=\"confirm\" formaction=\"ConfirmTask\" class=\"btn btn-default\">Confirm</button></td></tr>");
	out.println("</form>");
}else{
	
}
%>


<div>
<form action="PassDetails" method="post">
<input type="hidden" name="email" value="${email}"/>
<input type="hidden" name="password" value="${password}"/>
<input type="hidden" name="task_id" value="${task_id}"/>
<table>
<tr>
    <th>Task Name</th>
    <th><input type='text' name="task_name" value = "${task_name}" readonly></input></th>
  </tr>
      <tr>
       
      
      </tr>
      <tr> 
      <tr>
       
      
      </tr>
      <tr> 
      <tr>
       
      
      </tr>
      <tr> 
      
    <th>Task Time</th>
    <th><input type='text' name="task_time" value = "${task_time}" readonly></input></th>
  </tr>
  <tr>
    <th>Task Location</th>
    <th><input type='text' name="location" value = "${location}" readonly></input></th>
  </tr> 
  
    <tr>
    <th>Contact Details</th>
    <th><input type='text' name="contact" value = "${contact}" readonly></input></th>
  </tr> 
    <tr>
    <th>Task Description</th>
    <th><textarea rows="3" cols="20"name="task_description" readonly>${task_description}</textarea></th>
  </tr>
    <tr>
    <th>Your Budget</th>
    <th><input type='text' name="budget" value = "${budget}" readonly></input></th>
  </tr>
  
  <%
  if(status == "unaccepted"){
	  
  }else{
	  out.println("<tr><th>Helper ID Info</th><th><input type='text' name=\"expert_id\" value = \"" + expert_id + "\" readonly></input></th></tr>");
  }
  %>
  
<%--   <tr>
    <th>Helper ID Info</th>
    <th><input type='text' name="expert_id" value = "${expert_id}" readonly></input></th>
  </tr> --%>
  
  <tr>
    <th>Task Status</th>
    <th><input type='text' name="task_status" value = "<%= status%>" readonly></input></th>
  </tr>
  <% if (status == "unaccepted" | status == "accepted but not finished"){
	  out.println("<tr><th><input type=\"submit\" value=\"Update Task\"/>  </th></tr>");
  }else{
	  
  }
	  %>
  
    
  
        </table>
              </form>
             
              <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="go back">
 </div>
</body>
</html>