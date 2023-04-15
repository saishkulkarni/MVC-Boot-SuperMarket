<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
</head>
<body>
	<h1>Welcome to Customer Login Page</h1>
	<br>
	<h2>${msg}</h2>
	<br>
	<spring:form action="login" method="post"
		modelAttribute="login">
	Customer Id:<input type="text" name="id" placeholder="Enter Id">
		<br>
	Password:<input type="text" name="password"
			placeholder="Enter Password">
		<br>
		<button type="reset">Cancel</button>
		<button>Login</button>
	</spring:form>
	<br>
	<a href="signup"><button>New? Click here to Create an Account</button></a>

</body>
</html>