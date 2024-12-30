<%@page import="com.flm.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	<%String name=request.getParameter("name"); 
		String id=request.getParameter("user_id");%>
		
	<h1>Welcome <%=name %>!!</h1>
	
	<a href="redirecttobooking?user_id=<%=id %>">Book a Journey</a>
	</br>
	</br>
	<a href="redirecttocancel?user_id=<%=id %>">Cancel a Journey</a>
	</br>
	</br>
	<a href="redirecttoreshedule?user_id=<%=id %>">Reschedule a Journey</a>
	</br>
	</br>
	<a href="redirectLogin">Logout</a>
	
</body>
</html>