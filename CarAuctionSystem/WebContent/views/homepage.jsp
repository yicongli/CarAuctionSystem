<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
	<title>Insert title here</title>
</head>
<body>
<h2> Home Page </h2>
<hr /><br />
<div class='container'>
	<table style="with: 50%" class='table table-bordered table-striped'>
	<tr>
		<td>
	<% String username = request.getParameter("username"); %>
	<a>Welcome   <% out.println(username); %> User!!!! You have logged in.</a>
		</td>
	</tr>
	<tr></tr>
	<tr>
		<td></td>
		<td></td>
		<td><a href="login.jsp"><b>Logout</b></a></td>
	</tr>
	</table>
</div>
</body>
</html>