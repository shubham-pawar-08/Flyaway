<%@page import="com.flyaway.entities.Flights"%>
<%@page import="com.flyaway.Dao.FlightsdaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Gateway</title>
</head>
<body>
<h1>Payment Gateway</h1>
<%
int num=Integer.parseInt(request.getParameter("numofpersons"));
String dtoftravel=request.getParameter("dateoftravel");
int id=Integer.parseInt(request.getParameter("flightId"));
String passengers =null;
FlightsdaoImpl flightsdao = new FlightsdaoImpl();
Flights flight = flightsdao.getById(id);
int paymentAmount = flight.getPrice()*num;
%>
<%
int i=1;
while(i<=num){
	if(passengers==null){
		passengers = request.getParameter("passenger"+i+"name");
	}else{
	passengers = passengers +","+ request.getParameter("passenger"+i+"name");
	}
	i++;
}
%>
<form action="BookingConfirmation" method="post">
Payment Amount = <b><%=paymentAmount%> INR</b><br>
<input type="hidden" name="paymentAmount" id="paymentAmount" value="<%=paymentAmount%>"/>
<input type="hidden" name="persons" id="persons" value="<%=num%>"/>
<input type="hidden" name="dtoftravel" id="dtoftravel" value="<%=dtoftravel%>"/>
<input type="hidden" name="flid" id="flid" value="<%=id%>"/>
<input type="hidden" name="passdetails" id="passdetails" value="<%=passengers%>"/>

<br>Enter Card Number: <input type="text" id="cardnumber" name="cardnumber"/>
<br>Enter expiry date: <input type="date" id="expiry" name="expiry"/>
<br>Enter CVV number: <input type="number" id="cvv" name="cvv" maxlength="3"/>
<br><input type="submit" value="Pay"/>
</form>
</body>
</html>