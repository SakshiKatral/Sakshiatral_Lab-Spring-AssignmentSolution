<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
	<div align="center">
		<h1>Sign Up</h1>
		<form action="process-signup" method="post" modelAttributel="user">
			<div class="form-group">
				<label for="username">User Name:</label> <input type="text"
					id="username" name="username" placeholder="Enter username"
					required="required">
			</div>
			<br>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" placeholder="Enter password"
					required="required">
			</div>
			<br>
			<div class="form-group">
				<label for="roleName">User Role:</label> <input type="text"
					id="roleName" name="roleName" placeholder="eg: admin / user"
					required="required">
			</div>
			<br> <br>
			<div>
				<button type="submit" class="signupform">Sign Up</button>
			</div>
		</form>
	</div>

</body>
</html>