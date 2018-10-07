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
  <li><a href="/logout">Log out</a></li>
</ul>


<br />

<% 
	String flag = (String)request.getAttribute("updateFlag");
	request.removeAttribute("updateFlag");
	if(flag != null) { 
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
	if(flag != null) { 
		if (Integer.parseInt(flag) == 1) {
%>
		<p style = "color:blue; margin-left: 80px;"> <b>Add Success! </b></p>
<% 		} else {%>
		<p style = "color:red; margin-left: 80px;"> <b> Add Failed! </b></p>
<% 		}
	}%>

<div class='container'>

    <table id='cartable'class='table table-bordered table-striped'>
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
	            <input type="hidden" name="carID" value = "<%= car.getId() %>">
	            <td align="left"> <input type="text" name="register_number" value = "<%= car.getRegisterNumber() %>"/> </td>
	            <td align="left"> <input type="text" name="make" value = "<%= car.getMake() %>"/> </td>
	            <td align="left"> <input type="text" name="model" value = "<%= car.getModel() %>"/> </td>
	            <td align="left"> <input type="text" name="variant" value = "<%= car.getVariant() %>"/> </td>
	            <td align="left"> <input type="text" name="year" value = "<%= car.getYear() %>"/> </td>
                <td> <%= car.getEndtime() %></td>
                <td> <%= car.getCurrentBid() %></td>
                <td align="left"> <input type="submit" value="Update"> </td>
              </form>
              <form name="DeleteCars" action="auctionmanagement" method="post">
	            <input type="hidden" name="carID" value = "<%= car.getId() %>">
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
	            <td align="left"> <input type="text" name="time_left" value="dd:hh:mm"/> </td>
	            <td align="left"> <input type="text" name="current_bid"/> </td>
                <td align="left"> <input type="submit" value="Enroll"> </td>
              </form>
	        </tr>
    </table>
    
    
</div>

<script>
 var table = document.getElementById("cartable");
 for (var r = 0; r < table.rows.length - 1; r++) {
//iterate through rows
//rows would be accessed using the "row" variable assigned in the for loop
var row = table.rows[r];
var countDown = row.cells[5];
var countDownNum = row.cells[5].innerHTML;
// Update the count down every 1 second

function countDownFun() {
    // Get todays date and time
    var now = new Date().getTime();

    // Find the distance between now an the count down date
    var distance = parseInt(countDown.innerHTML) - now / 1000;

    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (60 * 60 * 24));
    var hours = Math.floor((distance % (60 * 60 * 24)) / (60 * 60));
    var minutes = Math.floor((distance % (60 * 60)) / ( 60));


    // Display the result in the element
    countDown.innerHTML = (days + "d " + hours + "h " + minutes + "m ");

     //If the count down is finished, write some text 
    if (distance < 0) {
        clearInterval(x);
        countDown.innerHTML = "Finish";
    }
  }

countDownFun();
 }
 </script>

</body>
</html>