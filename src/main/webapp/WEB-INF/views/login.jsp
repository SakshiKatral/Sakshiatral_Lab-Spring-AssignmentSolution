<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<div align="center">
		<c:if test="${param.error != null}">
			<i style="color: red">Ivalid Username or Password</i>
		</c:if>
		<c:if test="${param.logout != null}">
			<i style="color: blue">You are sucessfully logged out! Sign in
				again></i>
		</c:if>
		<h1>Login</h1>
		<form action="process_login" method="post">
			<div class="form-group">
				<label for="username">User Name:</label> <input type="text"
					id="username" name="username" placeholder="Enter username">
			</div>
			<br>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" placeholder="Enter password">
			</div>
			<br> <br>
			<div>
				<button type="submit" class="process_login">Sign in</button>
			</div>
			<br>
			<div>
				<a href="signup">Create new user</a>
			</div>
		</form>
	</div>
</body>
</html>