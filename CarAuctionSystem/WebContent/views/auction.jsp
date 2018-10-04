<%@page import="car.auction.domain.BiddingCar"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <title>Auction</title>
</head>
<body>
<h2> Auction </h2>
<hr />

<ul>
  <li><a href="/homepage">Home page</a></li>
  <li><a href="/auction">Auction</a></li>
  <li><a href="/history">Bought Cars</a></li>
  <li><a href="/logout">Log out</a></li>
</ul>


<br />

<% 
	String flag = (String)request.getAttribute("bidFlag");
	request.removeAttribute("bidFlag");
	if(flag != null && Integer.parseInt(flag) == 1) { 
		if (Integer.parseInt(flag) == 1) {
%>
		<p style = "color:blue; margin-left: 80px;"> <b>Bid Success! </b></p>
	<%  } else {%>
		<p style = "color:red; margin-left: 80px;"> <b>Bid Failed! </b></p>
<% 		}
	}%>

<div class='container'>

    <table class='table table-bordered table-striped'>
        <tr>
            <th>Reg.No.</th>
            <th>Make</th>
            <th>Model</th>
            <th>Variant</th>
            <th>Year</th>
            <th>Time Left</th>
            <th>Current Bid</th>
            <th> </th>
			<th> </th>
        </tr>
        <%
        	List<BiddingCar> list = (List<BiddingCar>)request.getAttribute("bidding_car");
        	if (list != null && list.size() != 0) {
	            for ( BiddingCar car : list) {
	        %>
	        <tr>
	          <form name="ListCars" action="auction" method="post">
	            <input type="hidden" name="register_number" value="<%= car.getRegisterNumber() %>">
                <td ><%= car.getRegisterNumber() %></td>
                <td><%= car.getMake() %></td>
                <td><%= car.getModel() %></td>
                <td><%= car.getVariant() %></td>
                <td><%= car.getYear() %></td>
                <td> <!-- TODO: use javascript update time --></td>
                <td> <!-- TODO: update bid price --></td>
                <td align="left"> <input type="text" name="bidding_price" /> </td>
                <td align="left"> <input type="submit" value="Bid"> </td>
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