<%@page import="com.flyaway.entities.Flights"%>
<%@page import="com.flyaway.Dao.FlightsdaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>
<body>
<h1>Passenger Details:</h1>
<b>You are about to book following flight on the following date, Kindly enter passenger details:</b><hr>
<%
int flightId=Integer.parseInt(request.getParameter("flightno"));
int persons = Integer.parseInt(request.getParameter("numofpersons"));
String date = request.getParameter("dateoftravel");

FlightsdaoImpl FlightsDao=new FlightsdaoImpl();
Flights flight = FlightsDao.getById(flightId);
%>
<form action="PaymentGateway.jsp" method="post">
<input type="hidden" id="flightId" name="flightId" value="<%=flight.getFlightId()%>"/>
No. of Persons:<br>
<input type="number" id="numofpersons" name="numofpersons" value="<%=persons%>"/><br>
Travel Date:<br>
<input type="date" id="dateoftravel" name="dateoftravel" value="<%=date%>"/><br><br>
<table border="1">
<tr>
<th>Flight ID</th>
<th>Airline</th>
<th>Route</th>
<th>Price</th>
<th>Source</th>
<th>Destination</th>
</tr>
<tr>
<td><%=flight.getFlightId() %></td>
<td><%=flight.getAirline() %></td>
<td><%=flight.getRoute() %></td>
<td><%=flight.getPrice() %></td>
<td><%=flight.getSource() %></td>
<td><%=flight.getDestination() %></td>
</tr>
</table><br><br>

<% int i=1;
while(i<=persons) { 
%>
	
	<br>Enter passenger <%=i %> name: <input type="text" name="passenger<%=i %>name" id="passenger<%=i %>>name"/><br>
	
	<%
	i++;
		} %>
<br>Total amount for <%=persons %> persons is <b>INR <%=persons*flight.getPrice() %>/-</b>
<br><input type="submit" value="Pay Now"/> 
</form>
<form action="Welcome.jsp"><br>
<input type="submit" value="Go Home"/>
</form>
</body>
</html>