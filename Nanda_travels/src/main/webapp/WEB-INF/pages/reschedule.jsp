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
	String message = request.getParameter("msg");
	String id = request.getParameter("user_id");
	%>
	<h1>Reschedule a Journey</h1>
	<form action="reschedulebook" method="post">
		<table>
			<tr>
				<td>User ID :</td>
				<td><input value="<%=id%>" name="user_id" readonly></td>
			</tr>
			<tr>
				<td>Booking :</td>
				<td><input type="number" name="book_id"></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
	</form>
	<br>
	<a href="redirecttoMainPage?user_id=<%=id %>">Main Page</a>
	
	<%
	if (message != null) {
	%>
	<h4><%=message%></h4>
	
	<%
	}
	%>
	
	<br/>
</body>
</html>