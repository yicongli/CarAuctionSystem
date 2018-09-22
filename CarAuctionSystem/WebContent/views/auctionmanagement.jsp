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
  <li><a href="/buyers">Buyers Information</a></li>
  <li><a href="/auctionmanagement">Auction Management</a></li>
  <li><a href="/history">Bought Cars</a></li>
  <li><a href="/login">Log out</a></li>
</ul>


<br />

<% 
	String flag = (String)request.getAttribute("updateFlag");
	request.removeAttribute("updateFlag");
	if(flag != null && Integer.parseInt(flag) == 1) { 
		if (Integer.parseInt(flag) == 1) {
%>
		<p style = "color:blue; margin-left: 80px;"> <b>Bid Success! </b></p>
<% 		} else {%>
		<p style = "color:red; margin-left: 80px;"> <b> Bid Failed! </b></p>
<% 		}
	}%>
	
<% 
	flag = (String)request.getAttribute("addFlag");
	request.removeAttribute("addFlag");
	if(flag != null && Integer.parseInt(flag) == 1) { 
		if (Integer.parseInt(flag) == 1) {
%>
		<p style = "color:blue; margin-left: 80px;"> <b>Add Success! </b></p>
<% 		} else {%>
		<p style = "color:red; margin-left: 80px;"> <b> Add Failed! </b></p>
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
	          <form name="ListCars" action="auctionmanagement" method="post">
	            <input type="hidden" name="operation_flag" value="1" />
	            <td align="left"> <input type="text" name="register_number" value = "<%= car.getRegisterNumber() %>"/> </td>
	            <td align="left"> <input type="text" name="make" value = "<%= car.getMake() %>"/> </td>
	            <td align="left"> <input type="text" name="model" value = "<%= car.getModel() %>"/> </td>
	            <td align="left"> <input type="text" name="variant" value = "<%= car.getVariant() %>"/> </td>
	            <td align="left"> <input type="text" name="year" value = "<%= car.getYear() %>"/> </td>
                <td> <!-- TODO: use javascript update time --></td>
                <td> <!-- TODO: update bid price --></td>
                <td align="left"> <input type="submit" value="Update"> </td>
              </form>
              <form name="DeleteCars" action="auctionmanagement" method="post">
	            <input type="hidden" name="register_number" value = "<%= car.getRegisterNumber() %>">
	            <input type="hidden" name="operation_flag" value="2">
                <td align="left"> <input type="submit" value="Delete"> </td>
              </form>
	        </tr>
	        <%
	            } // for loop
        	}
        %>
        
        	<tr>
	          <form name="AddCar" action="auctionmanagement" method="post">
	            <input type="hidden" name="operation_flag" value="0" />
	            <td align="left"> <input type="text" name="register_number"/> </td>
	            <td align="left"> <input type="text" name="make"/> </td>
	            <td align="left"> <input type="text" name="model"/> </td>
	            <td align="left"> <input type="text" name="variant"/> </td>
	            <td align="left"> <input type="text" name="year"/> </td>
	            <td align="left"> <input type="text" name="time_left"/> </td>
	            <td align="left"> <input type="text" name="current_bid"/> </td>
                <td align="left"> <input type="submit" value="Enroll"> </td>
              </form>
	        </tr>
    </table>
    
    
</div>

</body>
</html>