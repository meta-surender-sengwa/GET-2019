<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Users" />

<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Employee Details Update</title>
</head>

<body>
	<div class="p-3 mb-2 bg-primary text-white jumbotron" align="center">
		<h1 class="display-4">Update Employee Profile</h1>
	</div>

	<div align="center" class="container" style="margin-top: 60px">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Update your details here</h3>
			</div>

			<div class="card-body">
				<c:forEach items="${emplist}" var="employee">
					<div align="center" class="form-group">
						<input class="form-control" placeholder="profile image"
							type="file" name="pic" accept="image/*">
					</div><br>
					
					<div class="form-group">
						<input size="40%" class="form-control" type="text"
							value="${employee.fullname}">
					</div><br>
					
					<div class="form-group">
						<input size="40%" class="form-control" value="${employee.email}">
					</div><br>
					
					<div class="form-group">
						<input size="40%" class="form-control" value="${employee.gender}">
					</div><br>
					
					<div class="form-group">
						<input size="40%" class="form-control" value="${employee.organisation}">
					</div><br>
					
					<div class="form-group">
						<input size="40%" class="form-control" value="${employee.contact}">
					</div><br>
					
				</c:forEach>
			</div>
			
			<div class="form-group" align="center">
				<input class="btn btn-primary " name="submit" type="submit"
					value="Update" />
			</div>
		</div>
	</div>
</body>
</html>