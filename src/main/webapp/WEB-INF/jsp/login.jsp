<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Booking: Login</title>
</head>
<body>
	<form:form id="loginForm" modelAttribute="login" action="userlogin"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="userName">Username: </form:label></td>
				<td><form:input path="userName" name="userName" id="userName" />
				</td>
			</tr>
			<tr>
				<td><form:label path="passWord">Password:</form:label></td>
				<td><form:password path="passWord" name="password"
						id="passWord" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login">Login</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>