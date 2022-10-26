<%@page import="com.flyaway.Dao.PlacesDaoImpl"%>
<%@page import="com.flyaway.entities.Places"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>
	<h1>
		<center>Welcome to FlyAway ticket booking portal</center>
	</h1>
	<form action="AdminLogin.html" method="post">
		<input type="submit" value="Admin Login">
	</form>

	<h2>Ticket Booking:</h2>
	<b>Enter following details for booking:</b>
	<form action=SearchFlight method="post">
		<label for="traveldate">Select Travel date</label><br> <input
			type="date" id="traveldate" name="traveldate" required><br>
		<label for="source">Select source place:</label><br>

		<datalist id="places">
			<%
			List<Places> places = null;
			PlacesDaoImpl placesdao = new PlacesDaoImpl();
			places = placesdao.getAll();
			for (Places p : places) {
			%>
			<option value="<%=p.getPlaceName()%>" />
			<%
			}
			%>
		</datalist>
		<input type="text" name="source" list="places" required /><br> 
		<label for="destination">Select destination place:</label><br> 
		<input type="text" name="destination" list="places" required /><br> 
		<label for="persons">Enter number of persons</label><br> 
		<input type="number" name="persons" required><br> 
		<input type="submit" value="show available flights"><br>

	</form>
</body>
</html>