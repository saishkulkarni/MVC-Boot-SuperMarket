<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Merchant Login</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            font-size: 16px;
        }

        h1 {
            color: #333333;
            text-align: center;
            margin-top: 50px;
        }

        h2 {
            color: red;
            text-align: center;
        }

        form {
            width: 400px;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            background-color: #fff;
        }

        input[type="text"], input[type="password"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px 0;
            cursor: pointer;
            border-radius: 4px;
        }

        button[type="reset"] {
            background-color: #f44336;
        }

        a {
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Welcome to Merchant Login Page</h1>
    <br>
    <h2>${msg}</h2>
    <br>
    <spring:form action="login" method="post" modelAttribute="login">
        Merchant Id:
        <input type="text" name="id" placeholder="Enter Id">
        <br>
        Password:
        <input type="password" name="password" placeholder="Enter Password">
        <br>
        <button type="reset">Cancel</button>
        <button>Login</button>
    </spring:form>
    <br>
    <a href="signup">New? Click here to Create an Account</a>
    <br>
    <a href="/">
        <button>Home</button>
    </a>
</body>
</html>
