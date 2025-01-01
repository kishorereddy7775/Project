<%@page import="com.flm.model.Route"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking page</title>
</head>
<body>
	<%
	String message = request.getParameter("msg");
	String id = request.getParameter("user_id");
	String seats=request.getParameter("seats");
	%>
	<h1>Booking Page</h1>
	<form action="checkAvailability" method="post">
		<table>
			<tr>
				<td>Source :</td>
				<td><input type="text" name="source"></td>
			</tr>
			<tr>
				<td>Destination :</td>
				<td><input type="text" name="dest"></td>
			</tr>
			<tr>
				<td>Date of journey :</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td>Number of seats :</td>
				<td><input type="number" name="num"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Book!"></td>
			</tr>
		</table>
		<input type="hidden" name="user_id" value="<%=id%>">
	</form>
	<a href="redirecttoMainPage?user_id=<%=id%>">Main Page</a>
	<br>

	<%
	if (message != null && message.equalsIgnoreCase("No Buses are available in that route...!")) {
	%>
	<h4><%=message%></h4>
	<%
	}else if(message != null && message.contains("Successfully")){
	%>	
		<h4><%=message %></h1>
	<%	
	}
	
	else if (message != null && seats!=null) {
	%>
	<h4><%=message%></h4><br>
	<%List<Route> routes= (List<Route>)request.getAttribute("routes"); %>
	<table>
		<tr>
			<th>Route ID</th>
			<th>Bus Name</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date</th>
			<th>Number of Available seats</th>
			<th>Price of each ticket</th>
			<th>Conform Booking</th>
		</tr>	
		
		<%
		for (Route route : routes) {
			if(Integer.parseInt(seats)<=route.getNumberOfSeatsAvailable()){
		%>
		<tr>
			<td><%=route.getRouteId() %></td>
			<td><%=route.getBusName() %></td>
			<td><%=route.getSource() %></td>
			<td><%=route.getDestination() %></td>
			<td><%=route.getDate() %></td>
			<td><%=route.getNumberOfSeatsAvailable() %></td>
			<td><%=route.getPriceOfEachTicket() %></td>
			<td><a href="ConformBooking?route_id=<%=route.getRouteId() %>&user_id=<%=id %>&seats=<%=seats %>">Book</a></td>

		</tr>
			
		<%
			}
		}
		%>
	</table>
	<%
	}
	%>

</body>
</html>