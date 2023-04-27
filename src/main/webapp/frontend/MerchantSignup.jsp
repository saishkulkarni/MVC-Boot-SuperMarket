<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant Signup</title>
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

    form {
        width: 400px;
        margin: 0 auto;
        border: 1px solid #ccc;
        padding: 20px;
        border-radius: 5px;
        background-color: #fff;
    }

    input[type="text"], input[type="password"], input[type="email"], input[type="tel"], textarea {
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
<h1>Enter Merchant Details</h1><br>
<spring:form action="signup" method="post" modelAttribute="merchant">
Name:<input type="text" name="name" placeholder="Enter Name"><br>
Email:<input type="email" name="email" placeholder="Enter Email"><br>
Mobile:<input type="tel" pattern="[0-9]{10}" name="mobile" placeholder="Enter Mobile"><br>
Password:<input type="password" name="password" placeholder="Enter Password"><br>
<button type="reset">Cancel</button><button>Signup</button>
</spring:form>
<br>
<a href="login">Already Merchant? Click here to Login</a>
    <br>
    <a href="/">
        <button>Home</button>
    </a>
</body>
</html>
