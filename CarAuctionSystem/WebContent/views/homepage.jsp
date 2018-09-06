<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
	<title>Home page</title>
</head>
<body>
<h2> Home Page </h2>
<hr />

<% String path = request.getRequestURI().substring(request.getContextPath().length()); %>

<ul>
  <li><a href="/views/homepage.jsp" class="active">Home page</a></li>
  <li><a href="/views/viewbuyers.jsp">Buyers Information</a></li>
  <li><a href="/views/cars.jsp">Available Cars</a></li>
  <li><a href="/views/hostory.jsp">History</a></li>
  <li><a href="/views/login.jsp">Log out</a></li> <!-- TODO temporary -->
</ul>

<br />

<div class='container'>
	<table style="with: 50%" class='table table-bordered table-striped'>
	<tr>
		<td>
	<% String username = request.getParameter("username"); %>
	<a>Welcome   <% out.println(username); %> User!!!! You have logged in.</a>
		</td>
	</tr>
	</table>
</div>
</body>
</html>