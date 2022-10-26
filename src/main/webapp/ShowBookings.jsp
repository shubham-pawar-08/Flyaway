<%@page import="java.sql.ResultSet"%>
<%@page import="com.flyaway.Dao.BookingsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Bookings</title>
</head>
<body>
<a href="Welcome.jsp" >Go Home</a>
	<%
	BookingsDao bookingdao = new BookingsDao();
	ResultSet rs = bookingdao.getAll();
	%>
	<h1>Flight Booking History:</h1><hr>
	<table border="1">
		<tr>
			<th>BookingId</th>
			<th>Card Number</th>
			<th>Expiry Date</th>
			<th>CVV Number</th>
			<th>Passenger Details</th>
			<th>Payment Amount</th>
			<th>No. of persons</th>
			<th>Travel Date</th>
			<th>Booking Time</th>
			<th>Airline</th>
			<th>Route</th>
			<th>Source</th>
			<th>Destination</th>
		</tr>
		
			<%
			while (rs.next()) {
			%>
			<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getInt(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getInt(7)%></td>
			<td><%=rs.getInt(8)%></td>
			<td><%=rs.getString(9)%></td>
			<td><%=rs.getString(10)%></td>
			<td><%=rs.getString(12)%></td>
			<td><%=rs.getString(15)%></td>
			<td><%=rs.getString(16)%></td>
			<td><%=rs.getString(13)%></td>
			</tr>
			<%}%>
		
	</table>
</body>
</html>