<%@page import="com.flm.model.Booking"%>
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
	<%List<Booking> books=(List<Booking>)request.getAttribute("books"); 
	int id=books.get(0).getUserId();%>

	<h1>My Bookings</h1>
	
	<Table border="1" width="100%">
		<tr>
			<th>Booking Id</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date</th>
			<th>Seats Booked</th>
			<th>Amount Paid</th>
			<th>Cancel Action</th>
			<th>Reschedule Action</th>
		</tr>
		<%for(Booking book:books){
		%>
			<tr>
				<td><%=book.getBookingId() %></td>
				<td><%=book.getSource() %></td>
				<td><%=book.getDestination() %></td>
				<td><%=book.getDate() %></td>
				<td><%=book.getNumberOfSeatsRequired() %></td>
				<td><%=book.getPriceOfEachTicket()*book.getNumberOfSeatsRequired() %></td>
				<td><a href="cancelbooking?user_id=<%=book.getUserId() %>&book_id=<%=book.getBookingId() %>">Cancel</a></td>
				<td><a href="redirecttoreshedule?user_id=<%=book.getUserId() %>&book_id=<%=book.getBookingId() %>">Reschedule</a></td>
			</tr>
		<% 
		}
		%>
	</Table>
	<br>
	<br>
	<a href="redirecttoMainPage?user_id=<%=id %>">Main Page</a>
	<br>
	

</body>
</html>