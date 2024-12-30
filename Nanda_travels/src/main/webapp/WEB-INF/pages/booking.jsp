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
	} else if (message != null && message.equalsIgnoreCase("No seats Available!!")) {
	%>
	<h4><%=message%></h4>
	<%
	} else if (message != null) {
	%>
	<h4><%=message%></h4><br>
	
	<%
	}
	%>

</body>
</html>