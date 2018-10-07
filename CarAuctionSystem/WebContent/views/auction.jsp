<%@page import="car.auction.domain.BiddingCar"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <script src="//code.jquery.com/jquery.js"></script>
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
	<%  } else if (Integer.parseInt(flag) == 2) {%>
		<p style = "color:red; margin-left: 80px;"> <b>Bid Failed! </b></p>
<% 		}
	}%>

<div class='container'>

    <table id='cartable' class='table table-bordered table-striped'>
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
	            <input type="hidden" name="carID" value="<%= car.getId() %>">
                <td ><%= car.getRegisterNumber() %></td>
                <td><%= car.getMake() %></td>
                <td><%= car.getModel() %></td>
                <td><%= car.getVariant() %></td>
                <td><%= car.getYear() %></td>
                <td><%= car.getEndtime() %></td>
                <td><%= car.getCurrentBid() %></td>
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

<script>
 var table = document.getElementById("cartable");
 for (var i = 1, row; row = table.rows[i]; i++) {
//iterate through rows
//rows would be accessed using the "row" variable assigned in the for loop
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