<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
label {
	width: 100px; 
	display: block; 
	text-align: right;
	margin-right: 8px;
	margin-top: 8px;
	margin-bottom: 8px;
	text-align: right;
    clear: both;
    float:left;
    font-size: 14px;
    
}

input {
	width: 300px;
	border: 1px solid #666; 
	border-radius: 5px; 
	padding: 4px; 
	font-size: 14px;
}

</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>newStudent</title>
</head>
<body>
	<div class="container">

		<h3>Student Directory</h3>
		<hr>

		<p class="h4 mb-4">Student</p>


		<form action="save" method="post" modelAttribute="student">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text" id="name" 
					name="name" placeholder="Enter name" required>
			</div>
			<div class="form-group">
				<label for="department">Department:</label> <input type="text"
					id="department" name="department" 
					placeholder="Enter department" required="required">
			</div>
			<div class="form-group">
				<label for="country">Country:</label> <input type="text"
					id="country" name="country" 
					placeholder="Enter country" required>
			</div>
			<button type="submit" class="save">save</button>
			<br> <br> <a href="${pageContext.request.contextPath }/"
				style="font-size: 14px; font-weight: medium; text-decoration: underline;">Back
				to student List</a>
		</form>
	</div>
</body>
</html>