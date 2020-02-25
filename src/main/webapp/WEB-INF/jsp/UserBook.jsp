<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Tickets</title>
</head>
<body>

<h4>Welcome to the Booking page</h4>
<table>
<tr>
<td>Welcome dear ${user} you can continue the Ticket booking</td>
</tr>
</table>
<form:form id="SearchTrainTickets" modelAttribute="STT"
		action="STTS" method="get">
	<table align="center">
			<tr>
				<td><form:label path="traint">Check Train Tickets </form:label></td></tr></table>	
				<td align="left"><form:button id="train" name="train">Train</form:button>
</form:form>
<!-- 
<form:form id="SearchFlightTickets" modelAttribute="SFT"
		action="SFTS" method="get">
		<table align="center">
			<tr>
				<td><form:label path="flightt">Check Flight Tickets </form:label></td></tr></table>	
				<td align="left"><form:button id="flight" name="fligth">Flight</form:button>
</form:form>
<form:form id="SearchMovieTickets" modelAttribute="SMT"
		action="SMTS" method="get">
<table align="center">
			<tr>
				<td><form:label path="moviet">Check Movie Tickets </form:label></td></tr></table>	
				<td align="left"><form:button id="movie" name="movie">movie</form:button>		
</form:form> -->
</body>
</html>