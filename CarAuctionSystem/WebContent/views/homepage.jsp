<%@page import="car.auction.domain.Seller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="car.auction.domain.UserInfoManagementService" %>
<%@page import="car.auction.domain.Seller"%>

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
	<b><% out.println(username); %>, Welcome! You have logged in.</b>
		</td>
	</tr>
	</table>
</div>

<%  Seller seller = (Seller)request.getAttribute("userinfo"); 
	if (seller != null){
%>
<div class='container'>
	<table style="with: 50%" class='table table-bordered table-striped'>
		<tr>
			<td>UserName</td>
			<td><%= seller.getUsername() %></td>
		</tr>
			<tr>
			<td>Password</td>
			<td><%= seller.getPassword() %></td>
		</tr>
		<tr>
			<td>Car Pick-Up Location</td>
			<td><%= seller.getAddress() %></td>
		</tr>
	</table>
</div>
<% } %>

</body>
</html>