<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>


<head>

<meta charset="utf-8">
<title>Login</title>

</head>
<body>
<h1>Task-Helper Login</h1>
<form action="authentication/LoginServlet" method="post">
Email: <input type="text" name="email"><br>
Password: <input type="password" name="password"><br>
<input type="submit" value="Login">
</form>

<form  method="post">
<button type="submit" name="logout" formaction="register.jsp" class="btn btn-default">Register</button>
</form>
					
</body>
</html>