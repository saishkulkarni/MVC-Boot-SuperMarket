<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Verify OTP</title>
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
			font-size: 16px;
			line-height: 1.5;
			margin: 0;
			padding: 0;
		}
		
		h1 {
			color: #333;
			font-size: 28px;
			margin-top: 40px;
			margin-bottom: 20px;
			text-align: center;
		}
		
		form {
			margin: 0 auto;
			max-width: 500px;
			padding: 20px;
			background-color: #fff;
			box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
			border-radius: 4px;
		}
		
		input[type="text"] {
			display: block;
			margin-bottom: 20px;
			padding: 10px;
			width: 100%;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
			font-size: 16px;
			color: #333;
		}
		
		button {
			display: block;
			margin: 0 auto;
			padding: 10px 20px;
			background-color: #4CAF50;
			color: #fff;
			font-size: 16px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		
		a {
			display: block;
			margin-top: 20px;
			text-align: center;
			text-decoration: none;
			color: #4CAF50;
			font-size: 16px;
			border: 2px solid #4CAF50;
			padding: 10px 20px;
			border-radius: 4px;
			transition: background-color 0.3s ease-in-out;
		}
		
		a:hover {
			background-color: #4CAF50;
			color: #fff;
		}
	</style>
</head>
<body>
	<h1>${msg}</h1>
	<h1>${msg1}</h1>
	<form action="verifyotp" method="post">
		<label for="otp">Enter OTP:</label>
		<input type="text" id="otp" name="otp">
		<button type="submit">Verify</button>
	</form>
	<a href="/">Home</a>
</body>
</html>
