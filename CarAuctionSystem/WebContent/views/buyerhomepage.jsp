<%@page import="car.auction.domain.Seller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="car.auction.domain.UserInfoManagementService" %>
<%@page import="car.auction.domain.Buyer"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
	<title>Home page</title>
</head>
<body>
<h2> Home Page - Buyer</h2>
<hr />

<ul>
  <li><a href="/views/homepage.jsp" class="active">Home page</a></li>
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
	<b><% out.println(username); %>, Welcome! You have logged in.</b>
		</td>
	</tr>
	</table>
</div>

<%  Buyer buyer = (Buyer)request.getAttribute("userinfo"); 
	if (buyer != null){
%>
<div class='container'>
	<table style="with: 50%" class='table table-bordered table-striped'>
		<tr>
			<td>First Name</td>
			<td><%= buyer.getFirstname() %></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><%= buyer.getLastname() %></td>
		</tr>
		<tr>
			<td>UserName</td>
			<td><%= buyer.getUsername() %></td>
		</tr>
			<tr>
			<td>Password</td>
			<td><%= buyer.getPassword() %></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><%= buyer.getPhoneNumber() %></td>
		</tr>
	</table>
</div>
<% } %>

</body>
</html>