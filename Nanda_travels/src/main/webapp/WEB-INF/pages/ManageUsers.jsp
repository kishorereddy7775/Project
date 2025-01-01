<%@page import="com.flm.model.User"%>
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
	List<User> users = (List<User>) request.getAttribute("users");
	%>
	
	<h1>User Details</h1>

	<table border="1" width="100%">
		<tr>
			<th>User Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Mobile Number</th>
			<th>Account status</th>
			<th>Inactivate Action</th>
		</tr>

		<%
		for (User user : users) {
		%>
		<tr>
			<td><%=user.getUser_id() %></td>
			<td><%=user.getFirstName() %></td>
			<td><%=user.getLastName() %></td>
			<td><%=user.getGender() %></td>
			<td><%=user.getEmail() %></td>
			<td><%=user.getMobileNumber() %></td>
			<td><%=user.getActiveStatus() %></td>
			<td><a href="InactivateUser?email=<%=user.getEmail() %>">Inactivate</a></td>
		</tr>
			
		<%
		}
		%>
	
	</table>
	
	<br>
	<a href="redirecttoAgentMainPage">Main Page</a>

</body>
</html>