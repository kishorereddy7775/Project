<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Add Route</h1>

	<form action="saveRoute" method="post">

		<table>
			<tr>
				<td>Bus Name :</td>
				<td><input type="text" name="busName"></td>
			</tr>		
			<tr>
				<td>Source :</td>
				<td><input type="text" name="source"></td>
			</tr>
			<tr>
				<td>Destination :</td>
				<td><input type="text" name="destination"></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td>Seats :</td>
				<td><input type="number" name="seats"></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><input type="number" name="price"></td>
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