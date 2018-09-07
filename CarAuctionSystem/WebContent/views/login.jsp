<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>

<% 
	String flag = (String)session.getAttribute("registerFlag");
	session.removeAttribute("registerFlag");
	if(flag != null && Integer.parseInt(flag) == 1) { 
%>
	<p style = "color:blue; margin-left: 80px;"> <b>Register success! </b></p>
<% }%>

<% 
	flag = (String)request.getAttribute("loginFlag");
	if(flag != null && Integer.parseInt(flag) == 2) { 
%>
	<p style = "color:red; margin-left: 80px;"> <b>Login failed! </b></p>
<% }%>

<hr /><br />

<div class='container'>
	<form action="../login" method="post">
			<table style="with: 50%" class='table table-bordered table-striped'>
	 
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Login" />
			<input type="checkbox" name="sellerFlag" value="true" style = "margin-left: 15px"> I am seller
			<a href="/register" style = "margin-left: 30px"><b>register</b></a>
	</form>
</div>
</body>
</html>