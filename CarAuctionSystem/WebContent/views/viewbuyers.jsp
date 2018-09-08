<%@page import="java.util.List"%>
<%@page import="car.auction.domain.Buyer"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="car.auction.domain.UserInfoManagementService" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <title>Registered Buyers</title>
    
    <style type="text/css">	
.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
  background-color: #color;
}
</style>
</head>
<body>
<h2>Buyer List</h2>
<hr />

<% 
	String flag = (String)request.getAttribute("deleteFlag");
	if(flag != null && Integer.parseInt(flag) == 2) { 
%>
	<p style = "color:red; margin-left: 80px;"> <b>Register failed! </b></p>
	<hr />
<% }%>

<ul>
  <li><a href="/homepage">Home page</a></li>
  <li><a href="/buyers" class="active">Buyers Information</a></li>
  <li><a href="#">Available Cars</a></li>
  <li><a href="#">History</a></li>
  <li><a href="/login">Log out</a></li> <!-- TODO temporary -->
</ul>


<br />

<div class='container'>

    <table class='table table-bordered table-striped'>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone </th>
            <th>User Name</th>
            <th>Password</th>
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