<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
	
	<title>Student Registration Form</title>
</head>
<body>

	<div align="center"><br><h1>Student Registration Form</h1></div>
	
	<div class="container" align="center">
		<form:form action="AddStudentDetails" modelAttribute="student" method="POST">

			<form:errors cssClass="text-danger" /> <br>
			<div class="form-group">
				<label for="firstName">First Name</label> 
				<form:input path="firstName" cssClass="form-control" id="firstNameInput" placeholder="Enter First Name" />
				<form:errors path="firstName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="lastName">Last Name</label>
				<form:input path="lastName" cssClass="form-control" id="lastNameInput" placeholder="Enter Last Name" />
				<form:errors path="lastName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="fatherName">Father Name</label>
				<form:input path="fatherName" cssClass="form-control" id="fatherNameInput" placeholder="Enter Fathers Name" />
				<form:errors path="fatherName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="email">Email address</label>
				<form:input path="email" cssClass="form-control" id="enailInput" placeholder="Enter email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="studentClass">Student Class</label>
				<form:input path="studentClass" cssClass="form-control" id="classInput" placeholder="Enter Student Class" />
				<form:errors path="studentClass" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="age">Student Age</label>
				<form:input path="age" cssClass="form-control" id="ageInput" placeholder="Enter Student Age" />
				<form:errors path="age" cssClass="text-danger" />
			</div>
			
			<div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="/js/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
	
</body>
</html>