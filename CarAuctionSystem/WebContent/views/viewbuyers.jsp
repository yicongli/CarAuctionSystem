<%-- shopping Page  --%>

<%@page import="car.auction.domain.Buyer"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="car.auction.domain.Buyer" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <title>Registered Buyers</title>
</head>
<body>
<h2>Buyer List</h2>
<hr />

<ul>
  <li><a href="homepage.jsp" class="active">Home page</a></li>
  <li><a href="#">Buyers Information</a></li>
  <li><a href="cars.jsp">Available Cars</a></li>
  <li><a href="hostory.jsp">History</a></li>
  <li><a href="Login.jsp">Log out</a></li> <!-- TODO temporary -->
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
            for ( Buyer buyer : Buyer.getAllBuyers()) {
        %>
        <tr>
            <form name="ListBuyers" action="viewbuyers" method="post">
                <input type="hidden" name="buyerID" value="<%= buyer. getId()%>">
                <td><%= buyer.getFirstname() %></td>
                <td><%= buyer.getLastname() %></td>
                <td><%= buyer.getPhoneNumber() %></td>
                <td><%= buyer.getUsername() %></td>
                <td><%= buyer.getPassword() %></td>
                <td align="left"> <input type="submit" value="Delete"> </td>
            </form>
        </tr>
        <%
            } // for loop
        %>
    </table>
    
    
</div>

</body>
</html>