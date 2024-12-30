<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Welcome Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%
	String message = request.getParameter("msg");
	String num = request.getParameter("num");
	%>
	<h1>Welcome to Nanda's Travels</h1>
	<form action="LoginValidation" method="post">
		<table>
			<tr>
				<td>User ID :</td>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
				<td><a href="Signup.html">Sign up</a></td>
			</tr>
		</table>
	</form>
	<%
	if (message != null && message.equalsIgnoreCase("Invalid Password")) {
	%>
	<h4><%=message%></h4>
	<h4><%=num%>
		attempts remaining
	</h4>
	<%
	}else if(message != null && message.equalsIgnoreCase("Account Locked")){
	%>
	<h4><%=message%></h4>
	<a href="redirecttoUnlock">Unlock account</a>
	<%
	}
	%>
</body>
</html>
