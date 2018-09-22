<%@page import="car.auction.domain.Seller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="car.auction.domain.UserInfoManagementService" %>
<%@page import="car.auction.domain.Seller"%>
<%@page import="car.auction.domain.Buyer"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
	<title>Home page</title>
</head>

<%  
	Boolean isSeller = (Boolean)session.getAttribute("sellerflag"); 
	if (isSeller.booleanValue()){
%>

<body>
<h2> Home Page - Seller</h2>

<hr />

<ul>
  <li><a href="/homepage" class="active">Home page</a></li>
  <li><a href="/buyers">Buyers Information</a></li>
  <li><a href="#">Available Cars</a></li>
  <li><a href="/history">Sold Cars</a></li>
  <li><a href="/login">Log out</a></li> <!-- TODO temporary -->
</ul>

<br />

<div class='container'>
	<table style="with: 50%" class='table table-bordered table-striped'>
	<tr>
		<td>
	<% Seller seller = (Seller)session.getAttribute("userinfo"); %>
	<b><% out.println(seller.getUsername()); %>, Welcome! You have logged in.</b>
		</td>
	</tr>
	</table>
</div>

<%  
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
	
	<a href="/update"><b>Update</b></a>
</div>
<% } %>

</body>

<%  }else{
%>

<body>
<h2> Home Page - Buyer</h2>
<hr />

<ul>
  <li><a href="/homepage" class="active">Home page</a></li>
  <li><a href="#">Available Cars</a></li>
  <li><a href="/history">Bought Cars</a></li>
  <li><a href="/login">Log out</a></li> <!-- TODO temporary -->
</ul>

<br />

<div class='container'>
	<table style="with: 50%" class='table table-bordered table-striped'>
	<tr>
		<td>
	<% Buyer buyer = (Buyer)session.getAttribute("userinfo");  %>
	<b><% out.println(buyer.getUsername()); %>, Welcome! You have logged in.</b>
		</td>
	</tr>
	</table>
</div>

<%  
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
	
	<a href="/update"><b>Update</b></a>
</div>
<% } %>

</body>

<%  }
%>
</html>