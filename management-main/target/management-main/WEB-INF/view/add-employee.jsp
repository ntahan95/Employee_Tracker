<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="/management-main/URLToReachResourcesFolder/css/add-employee.css">
<link rel="stylesheet" type="text/css" href="/management-main/URLToReachResourcesFolder/css/my-style-sheet.css">
</head>
<body>

	<!-- Create a spring form for user to enter data -->

	<div align="center">
		<h3>Add Employee</h3>

		<form:form action="save-employee" modelAttribute="employee" method="POST">
			
			<form:hidden path="id" />
			
			<label>Name : </label>
			<form:input path="name" />
			<br />

			<label>Mobile Number : </label>
			<form:input path="mobile" />
			<br />

			<label>Company name : </label>
			<form:input path="company" />
			<br />

			<input type="submit" value="Submit" class="myButton">

		</form:form>

	</div>

</body>
</html>