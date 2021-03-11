<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/management-main/URLToReachResourcesFolder/css/my-style-sheet.css">

</head>
<body class="myFonts">

	<h1 align="center">Employee Management</h1>

	<div class="container">

		<form action="showAddEmployee">
			<input type="submit" value="Add Employee" class="btn btn-outline-primary">

		</form>
		<br>

		<table border="3" class="table table-striped">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Company</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
			</thead>

			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.mobile}</td>
					<td>${employee.company}</td>
					<td><a href="updateEmployee?userId=${employee.id}">Update</a></td>
					<td><a href="deleteEmployee?userId=${employee.id}"
						onclick="if(!(confirm('Are you sure you want to delete the record of ${employee.name}?'))) return false">Delete</a></td>
				</tr>
			</c:forEach>

		</table>

		<img alt="fake image"
			src="/management-main/URLToImagesFolder/employee.png">

	</div>

</body>
</html>