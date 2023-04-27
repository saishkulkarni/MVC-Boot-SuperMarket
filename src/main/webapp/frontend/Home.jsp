<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
</style>
</head>
<body>
<h1>${msg}</h1>
	<h1>Welcome to Super Market Home Page</h1>
	<br>
	<a href="customer/login"><button>Login as Customer</button></a>
	<br>
	<br>
	<a href="merchant/login"><button>Login as Merchant</button></a>
	<br>
	<br>
	<a href="admin/login"><button>Login as Admin</button></a>
	<br>
	<br>
</body>
</html>
