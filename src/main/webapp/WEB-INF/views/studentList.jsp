<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
response.setStatus(403);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Directory</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<%-- <%@include file="./base.jsp"%> --%>

</head>
<body>
	<div align="left">
		<div class="container">
			<h4>Student Details</h4>
			<br> <br> <a href="addStudent" class="btn btn-success"
				style="color: black;">Add Student</a>
			<div align="right">
				<form action="logout" method="post">
					<input type="submit" value="logout">
				</form>
			</div>
			<br> <br>
			<table class="table table-bordered table-striped">

				<thead class="thead-dark">
					<tr>
						<div align="centre">
							<th>Student Id</th>
							<th>Name</th>
							<th>Department</th>
							<th>Country</th>
							<th>Edit</th>
							<th>Delete</th>
						</div>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${student}">
						<tr>
							<td>${student.id }</td>
							<td>${student.name }</td>
							<td>${student.department }</td>
							<td>${student.country }</td>
							<td><a href="editStudent/${student.id }"
								class="btn btn-warning"
								style="font-size: 12px; font-weight: bold;"> Edit </a></td>
							<td><a href="deleteStudent/${student.id}"
								class="btn btn-danger"
								style="font-size: 12px; font-weight: bold;"
								onclick="return confirm('Are you sure ou want to delete this customer?');">
									Delete </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>