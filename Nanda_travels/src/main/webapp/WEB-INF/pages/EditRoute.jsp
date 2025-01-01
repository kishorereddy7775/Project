<%@page import="com.flm.model.Route"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%Route route=(Route)request.getAttribute("route"); %>
<h1>Edit Route</h1>

	<form action="editRoute" method="post">
		
		<input type="hidden" name="route_id" value="<%=route.getRouteId() %>">

		<table>
			<tr>
				<td>Bus Name :</td>
				<td><input type="text" name="busName" value="<%=route.getBusName() %>"></td>
			</tr>
			<tr>
				<td>Source :</td>
				<td><input type="text" name="source" value="<%=route.getSource() %>"></td>
			</tr>
			<tr>
				<td>Destination :</td>
				<td><input type="text" name="destination" value="<%=route.getDestination() %>"></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><input type="date" name="date" value="<%=route.getDate() %>"></td>
			</tr>
			<tr>
				<td>Seats :</td>
				<td><input type="number" name="seats" value="<%=route.getNumberOfSeatsAvailable() %>"></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><input type="number" name="price" value="<%=route.getPriceOfEachTicket() %>"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="Submit"></td>
			</tr>


		</table>

	</form>

	<br>
	<a href="redirecttoAgentMainPage">Main Page</a>

	<br>

	<a href="redirecttoManageRoutes">Manage Routes</a>


</body>
</html>