<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="with: 50%">
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
</body>
</html>