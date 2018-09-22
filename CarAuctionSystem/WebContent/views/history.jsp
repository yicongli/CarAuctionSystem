<%@page import="java.util.List"%>
<%@page import="car.auction.domain.Buyer"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="car.auction.domain.UserInfoManagementService" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <title>Bought Cars</title>
    
    <style type="text/css">	
.table tbody tr:hover td, .table tbody tr:hover th {
    background-color: #eeeeea;
}
</style>
</head>
<body>
<h2>Buyer List</h2>
<hr />

<ul>
  <li><a href="/homepage">Home page</a></li>
  <li><a href="#">Available Cars</a></li>
  <li><a href="/boughtcars">Bought Cars</a></li>
  <li><a href="/login">Log out</a></li> 
</ul>


<br />

<div class='container'>

    <table class='table table-bordered table-striped'>
        <tr>
            <th>Reg.no.</th>
            <th>Make</th>
            <th>Model </th>
            <th>Variant</th>
            <th>Year</th>
            <th>Price($)</th>
            <th>Purchase Date</th>
            <th>Seller</th>
            <th>Car Pick-up Location</th>
            <th> </th>

        </tr>
        <%
        	List<Buyer> list = UserInfoManagementService.getInstance().getAllBuyers();
        	if (list != null) {
	            for ( Buyer buyer : list) {
	        %>
	        <tr onclick="document.location='modifybuyer?id=<%= buyer.getId()%>';">
	            <form name="ListBuyers" action="buyers" method="post">
	                <input type="hidden" name="username" value="<%= buyer.getUsername()%>">
	                <td ><%= buyer.getFirstname() %></td>
	                <td><%= buyer.getLastname() %></td>
	                <td><%= buyer.getPhoneNumber() %></td>
	                <td><%= buyer.getUsername() %></td>
	                <td><%= buyer.getPassword() %></td>
	                <td align="left"> <input type="submit" value="Delete"> </td>
	            </form>
	        </tr>
	        <%
	            } // for loop
        	}
        %>
    </table>
    
    
</div>

</body>
</html>