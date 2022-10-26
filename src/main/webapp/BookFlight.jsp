<%@page import="com.flyaway.entities.Flights"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.Dao.FlightsdaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Flight</title>
</head>
<body>
<h1>Book Flight</h1>
<%
int persons=Integer.parseInt(request.getParameter("persons"));
String Date = request.getParameter("traveldate");
%>

<form action="PassengerDetails.jsp" method="post">
No. of Persons:<br>
<input type="text" id="numofpersons" name="numofpersons" value="<%=persons%>"/><br>
Travel Date:<br>
<input type="date" id="dateoftravel" name="dateoftravel" value="<%=Date%>"/><br>
Enter the flight Id to book:<br>
<input type="number" id="flightno" name="flightno"/>
<input type="submit" value="Book Flight"/>
</form>
</body>
</html>