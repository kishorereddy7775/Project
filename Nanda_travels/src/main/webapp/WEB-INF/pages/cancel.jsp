<%@page import="com.flm.model.Booking"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int id=Integer.parseInt(request.getParameter("user_id")); 
		Booking bo=(Booking)request.getAttribute("booking");%>
	<h1>Booking Cancelation</h1>
	<form action="cancelbooking" method="post">
		<table>
			<tr>
				<td>User ID : </td>
				<td><input value="<%=id %>" name="user_id" readonly></td>
			</tr>
			<tr>
				<td>Booking : </td>
				<td><input type="number" name="book_id"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
		
	</form>
	
	<br/>
	
	<a href="redirecttoMainPage?user_id=<%=id %>">Main Page</a>
	
	<br/>
	
	<%String message=request.getParameter("msg");
		if(message!= null && !message.equalsIgnoreCase("null")){
	%>
		<h1><%=message %></h1>
		<p><%=bo.getPriceOfEachTicket()*bo.getNumberOfSeatsRequired() %> /- will be credited to your account in 7 days.</p>
	<%
		}
	%>
	
</body>
</html>