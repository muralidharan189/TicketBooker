<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket booking : Register</title>
</head>
<body>
	<form:form id="Register" modelAttribute="register"
		action="registeruser" method="post">
		<table align="center">
			<tr>
				<td>Enter your details</td>
			</tr>
			<tr>
				<td><form:label path="userName">Username: </form:label></td>
				<td><form:input path="userName" name="userName" id="userName" />
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">firstname:</form:label></td>
				<td><form:input path="firstname" name="firstname"
						id="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">lastname:</form:label></td>
				<td><form:input path="lastname" name="lastname"
						id="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">email:</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="address">address:</form:label></td>
				<td><form:input path="address" name="address" id="address" />
				</td>
			</tr>
			<tr>
				<td><form:label path="phone">phone:</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" /></td>
			</tr>
			<tr>
				<td><form:label path="gender">gender:</form:label></td>
				<td><form:input path="gender" name="gender" id="gender" />
				</td>
			</tr>
			<tr>
				<td><form:label path="date">date:</form:label></td>
				<td><form:input path="date" name="date" id="date" /></td>
			</tr>
			<tr>
				<td><form:label path="age">age:</form:label></td>
				<td><form:input path="age" name="age" id="age" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="register" name="register">register</form:button>
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