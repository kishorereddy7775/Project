<%@page import="com.flm.model.Route"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Route> routes = (List<Route>) request.getAttribute("routes");
	%>
	
	<h1>Routes Details</h1>
	
	<br>
	
	<a href="redirecttoAddroute" >Add Route</a>
	
	<br>
	<br>

	<table border="1" width="100%">
		<tr>
			<th>Route ID</th>
			<th>Bus Name</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date</th>
			<th>Number of Available seats</th>
			<th>Price of each ticket</th>
			<th>Edit</th>
		</tr>

		<%
		for (Route route : routes) {
		%>
		<tr>
			<td><%=route.getRouteId() %></td>
			<td><%=route.getBusName() %></td>
			<td><%=route.getSource() %></td>
			<td><%=route.getDestination() %></td>
			<td><%=route.getDate() %></td>
			<td><%=route.getNumberOfSeatsAvailable() %></td>
			<td><%=route.getPriceOfEachTicket() %></td>
			<td><a href="redirecttoeditroute?route_id=<%=route.getRouteId() %>">Edit</a></td>

		</tr>
			
		<%
		}
		%>
	
	</table>
	
	<br>
	<a href="redirecttoAgentMainPage">Main Page</a>

</body>
</html>