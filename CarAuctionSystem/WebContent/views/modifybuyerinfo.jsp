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

	<title>Modify Buyer Information</title>
</head>

<body>
<h2> Home Page - Seller</h2>
<hr />

<ul>
  <li><a href="/update">Home page</a></li>
  <li><a href="/buyers" class="active">Buyers Information</a></li>
  <li><a href="#">Available Cars</a></li>
  <li><a href="#">History</a></li>
  <li><a href="/login">Log out</a></li> <!-- TODO temporary -->
</ul>

<br />

<% Buyer buyer = (Buyer)request.getAttribute("buyerinfo");  %>

<div class='container'>
<form action="../modifybuyer" method="post">
			<table style="with: 50%" class='table table-bordered table-striped'>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" value = "<%= buyer.getFirstname() %>" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" value = "<%= buyer.getLastname() %>"/></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" value = "<%= buyer.getUsername() %>"/></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="text" name="password" value = "<%= buyer.getPassword() %>"/></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contact" value = "<%= buyer.getPhoneNumber() %>"/></td>
				</tr>
			</table>
			<input type="hidden" name="id" value="<%= buyer.getId()%>">
			<input type="submit" value="Submit" />
			<a href="/buyers" style = "margin-left: 30px"><b>Back to Buyer Information</b></a>
</form>
</div>

</body>

</html>