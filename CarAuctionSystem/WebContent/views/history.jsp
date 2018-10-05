<%@page import="car.auction.auth.AppSession"%>
<%@page import="car.auction.domain.CarHistory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="car.auction.domain.AuctionManagementService" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <title>History of Cars</title>
</head>
<body>

<%
	boolean isSeller = AppSession.hasRole(AppSession.SELLER_ROLE); 
	if (isSeller){
%>
<h2>Sold Cars</h2>
<hr />

<ul>
  <li><a href="/homepage">Home page</a></li>
  <li><a href="/buyers">Buyers Information</a></li>
  <li><a href="/auctionmanagement">Auction Management</a></li>
  <li><a href="/history">Sold Cars</a></li>
  <li><a href="/logout">Log out</a></li> 
</ul>

<%
	} else {
%>
<h2>Bought Cars</h2>
<hr />

<ul>
  <li><a href="/homepage">Home page</a></li>
  <li><a href="/auction">Auction</a></li>
  <li><a href="/history">Bought Cars</a></li>
  <li><a href="/logout">Log out</a></li> 
</ul>
<%
	}
%>
<br />

<div class='container'>
<%
	if (isSeller){
%>
<table class='table table-bordered table-striped'>
        <tr>
            <th>Reg.no.</th>
            <th>Make</th>
            <th>Model </th>
            <th>Variant</th>
            <th>Year</th>
            <th>Sales Price($)</th>
            <th>Sales Date</th>
            <th>Buyer</th>

        </tr>
        <%
        	List<CarHistory> list = (List<CarHistory>)request.getAttribute("history");
                	if (list != null && list.size() != 0) {
        	            for ( CarHistory history : list) {
        %>
	        <tr>
                <td ><%= history.getRegisterNumber() %></td>
                <td><%= history.getMake() %></td>
                <td><%= history.getModel() %></td>
                <td><%= history.getVariant() %></td>
                <td><%= history.getYear() %></td>
                <td><%= history.getSalesPrice() %></td>
                <td><%= history.getSalesdate() %></td>
                <td><%= history.getBuyerName() %></td>
	        </tr>
	        <%
	            } // for loop
        	}
        %>
    </table>

<% } else {%>
<table class='table table-bordered table-striped'>
        <tr>
            <th>Reg.no.</th>
            <th>Make</th>
            <th>Model </th>
            <th>Variant</th>
            <th>Year</th>
            <th>Price($)</th>
            <th>Purchase Date</th>
            <th>Car Pick-up Location</th>

        </tr>
        <%
        	List<CarHistory> list = (List<CarHistory>)request.getAttribute("history");
        	if (list != null && list.size() != 0) {
	            for ( CarHistory history : list) {
	        %>
	        <tr>
                <td ><%= history.getRegisterNumber() %></td>
                <td><%= history.getMake() %></td>
                <td><%= history.getModel() %></td>
                <td><%= history.getVariant() %></td>
                <td><%= history.getYear() %></td>
                <td><%= history.getSalesPrice() %></td>
                <td><%= history.getSalesdate() %></td>
                <td><%= history.getPickUpLocation() %></td>
	        </tr>
	        <%
	            } // for loop
        	}
        %>
    </table>
<% } %>
</div>

</body>
</html>