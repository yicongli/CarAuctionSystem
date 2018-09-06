<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
<title>Registration Form</title>
</head>
<body>
<h2>Register Form</h2>

<% 
	String flag = (String)request.getAttribute("registerFlag");
	if(flag != null && Integer.parseInt(flag) == 2) { 
%>
	<p style = "color:red; margin-left: 80px;"> <b>Register failed! </b></p>
<% }%>

<hr /><br />

<div class='container'>
	<form action="../registerServlet" method="post">
			<table style="with: 50%" class='table table-bordered table-striped'>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contact" /></td>
				</tr></table>
			<input type="submit" value="Submit" />
			<a href="/views/login.jsp" style = "margin-left: 30px"><b>Back to Login</b></a>
	</form>
</div>
</body>
</html>