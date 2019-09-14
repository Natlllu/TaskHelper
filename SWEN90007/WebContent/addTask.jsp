<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Task</title>
</head>
<body>
<div>
<form action="AddTask" method="post">
<table>
<tr>
    <th>Task Title</th>
    <th><input type='text' name="task_name"></input></th>
  </tr>
      <tr>
    <th>Task time</th>
    <th><input type='text' name="task_time" ></input></th>
  </tr>
  <tr>
    <th>Task Location</th>
    <th><input type='text' name="location"  ></input></th>
  </tr> 
  
    <tr>
    <th>Contact Details</th>
    <th><input type='text' name="contact"  ></input></th>
  </tr> 
    <tr>
    <th>Task Description</th>
    <th><textarea rows="3" cols="20"name="task_description" > </textarea></th>
  </tr>
    <tr>
    <th>Your Budget</th>
    <th><input type='text' name="budget"  ></input></th>
  </tr>
    <tr>

    <th><input type="submit" value="Post"/>  </th>
  </tr>
  
        </table>
              </form>
 </div>
</body>
</html>