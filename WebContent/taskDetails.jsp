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
<form action="../taskHelperController/ViewDetails" method="get">
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

  
  <tr>
    <th>Task Status</th>
    <th><input type='text' name="task_status" value = "${task_status}" readonly></input></th>
  </tr>
 
  
        </table>
              </form>
             
              <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="go back">
 </div>
</body>
</html>