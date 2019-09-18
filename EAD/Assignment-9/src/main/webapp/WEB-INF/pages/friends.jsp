<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="pageTitle" scope="request" value="Users" />

<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Show Friends</title>
</head>
<body>
	<div class="p-3 mb-2 bg-primary text-white jumbotron" align="center">
		<h1 class="display-4">Showing Your Friends</h1>
	</div>

	<div class="container" style="margin-top: 60px">
		<div class="card">
			<div class="card-header">
				<h3 align="center" class="card-title">Employee</h3>
			</div>
			
			<div class="card-body">
				<c:if test="${not empty msg}">
					<div class="alert alert-success alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">x</span></button>
					</div>
				</c:if>
				<div class="table-responsive">
					<table align="center" border="1" class="table table-striped table-dark">
						<thead>
							<tr>
								<th>Profile Picture</th>
								<th>Full Name</th>
								<th>Email</th>
								<th>Gender</th>
								<th>Organization</th>
								<th>Contact Number</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${emplist}" var="employee">
								<tr>
									<td><img src="/img/vinay.jpg" class="img-rounded" alt="Cinque Terre" width="100" height="100" /> </td>
									<td>${employee.fullname}</td>
									<td>${employee.email}</td>
									<td>${employee.gender}</td>
									<td>${employee.organisation}</td>
									<td>${employee.contact}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="footer.jsp"%>
</body>
</html>