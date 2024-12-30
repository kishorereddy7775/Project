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
	%>
	<form action="UnlockAccount" method="post">
		<table>
			<tr>
				<td>User ID :</td>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
	</form>
	<%
	if (message != null && message.equalsIgnoreCase("Account Unlocked Successfully!!")) {
	%>
	<h4><%=message%></h4> <br>
	
	<a href="redirectLogin">Login page</a>
	
	<%
	}
	%>
</body>
</html>