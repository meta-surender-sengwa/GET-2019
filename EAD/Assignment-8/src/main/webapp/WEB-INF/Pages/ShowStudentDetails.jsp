<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Students</title>
</head>
<body>

	<div class="container" align="center">
		<form:form modelAttribute="student">
			<form:errors cssClass="text-danger" />
			<br>
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Students</h3>
				</div>
				
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Father's Name</th>
									<th>Email</th>
									<th>Class</th>
									<th>Age</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${student1}" var="student">
									<tr>
										<td>${student.firstName}</td>
										<td>${student.lastName}</td>
										<td>${student.fatherName}</td>
										<td>${student.email}</td>
										<td>${student.studentClass}</td>
										<td>${student.age}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</form:form>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="/js/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>