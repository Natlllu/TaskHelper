<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
  
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}

.texttext{

        color:  #43A047;
        font-family: sans-serif;
        font-size:25px;
        text-align: center;

}
body {
  background: #76b852; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #76b852, #8DC26F);
  background: -moz-linear-gradient(right, #76b852, #8DC26F);
  background: -o-linear-gradient(right, #76b852, #8DC26F);
  background: linear-gradient(to left, #76b852, #8DC26F);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}

.parent {
    background: url('yourimage') no-repeat;
    width: 100px;
    height: 30px;
    overflow: hidden;
}

.parent select {
    background: transparent;
    border: none;
    padding-left: 10px;
    width: 120px;
    height: 100%;
}

.full-width {
  width: 100%;
}

.input-line {
  background: none;
  margin-bottom: 10px;
  line-height: 2.4em;
  color: #505050;
  font-family: roboto;
  font-weight: 300;
  letter-spacing: 0px;
  letter-spacing: 0.02rem;
  font-size: 19px;
  font-size: 1.2rem;
  border-bottom: 1px solid rgba(255, 255, 255, 0.65);
  -webkit-transition: all .2s ease;
  transition: all .2s ease;
}
</style>
<meta charset="utf-8">
<title>Register</title>
</head>
<body>

<div class="login-page">
  <div class="form">
    <form action="taskHelperController/RegisterServlet" method="post">
      <h1 class="texttext">Join In Us</h1>
      <div>
        <input type='text' name="userName" placeholder='Username' class='input-line full-width'></input>
        <input type='password' name="password" placeholder='Password' class='input-line full-width'></input>
        <input type='text' name="email" placeholder='Email' class='input-line full-width'></input>
        <input type='text' name="user_contact"  placeholder='Contact number' class='input-line full-width'></input>
        <select name="user_type"  value="user_type" class="input-line full-width" style="font-size:15px;background-color:#F0F0F0">     
            <option class="input-line full-width " value="0"> &nbsp &nbsp Customer</option> 
            <option class="input-line full-width " value="1" > &nbsp &nbsp Expert</option>     
        </select >  
        <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
        <input type="submit" value="Register" class='ghost-round full-width'/>        
 </div>
      
    </form>

 </div>
 </div>

</body>
</html>