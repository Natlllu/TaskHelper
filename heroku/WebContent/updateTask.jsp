<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Details</title>
</head>
<body>
<h3>Task Details</h3>

<div>
<form action= "UpdateTask"method="post">
<input type="hidden" name="email" value="${email}"/>
<input type="hidden" name="password" value="${password}"/>
<input type="hidden" name="task_id" value="${task_id}"/>
<table>



<tr>
    <th>Task Name</th>
    <th><input type='text' name="task_name" value = "${task_name}" ></input></th>
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
    <th><input type='text' name="task_time" value = "${task_time}"></input></th>
  </tr>
  <tr>
    <th>Task Location</th>
    <th><input type='text' name="location" value = "${location}"></input></th>
  </tr> 
  
    <tr>
    <th>Contact Details</th>
    <th><input type='text' name="contact" value = "${contact}" ></input></th>
  </tr> 
    <tr>
    <th>Task Description</th>
    <th><textarea rows="3" cols="20"name="task_description">${task_description}</textarea></th>
  </tr>
    <tr>
    <th>Your Budget</th>
    <th><input type='text' name="budget" value = "${budget}"></input></th>
  </tr>
  
  <%
  /*
  if(status == "unaccepted"){
	  
  }else{
	  out.println("<tr><th>Helper ID Info</th><th><input type='text' name=\"expert_id\" value = \"" + expert_id + "\" readonly></input></th></tr>");
  }
  */
  %>
  
<%--   <tr>
    <th>Helper ID Info</th>
    <th><input type='text' name="expert_id" value = "${expert_id}" readonly></input></th>
  </tr> --%>
  
  <tr>
    <th>Task Status</th>
    <th><input type='text' name="task_status" value = "${task_status}" readonly></input></th>
  </tr>
  <% 
  /*
  if (status == "unaccepted" | status == "accepted but not finished"){
	  out.println("<tr><th><input type=\"submit\" value=\"Update Task\"/>  </th></tr>");
  }else{
	  
  }
	 */ 
	 %>  
        </table>

        
        <button value="${task_id}" type="submit" name="Save" formaction="UpdateTask">Save</button>  
        
              </form>
             
              <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="go back">           
 </div>
</body>
</html>