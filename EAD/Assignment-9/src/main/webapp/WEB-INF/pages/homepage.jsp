<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Parking System - Home</title>
</head>
<body>
	<div align="center">
		<div class="p-3 mb-5 text-white jumbotron bg-primary " align="center">
			<h1 class="display-4">Welcome to Meta Parking System</h1>
		</div>

		<div class="container border border-success rounded d-flex justify-content-center  p-5">
			<form:form modelAttribute="employeeLogin" action="home" method="POST">
				<h2 class="display-4 p-0 text-primary" align="center">Login</h2>
			
				<div class="form-group">
					<form:label path="email" for="inputEmail"></form:label>
					<form:input path="email" size="50%" type="email"
						class="form-control" id="inputEmail" aria-describedby="emailHelp"
						placeholder="Enter email" />
					<form:errors path="email" cssClass="text-danger" />
				</div><br>
				
				<div class="form-group">
					<form:label path="password" for="inputPassword"></form:label>
					<form:input path="password" size="50%" type="password"
						class="form-control" id="inputPassword" placeholder="Password" />
					<form:errors path="password" cssClass="text-danger" />
				</div><br>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary form-control">Submit</button>
				</div><br><br>
				
			</form:form>
		</div>
		
		<div class="p-3 mb-5 " align="center">
			<p>if not registered, then first register !!</p>
			<input type="button" class="btn btn-primary " value="Register"
				onClick="window.location.href='signUp'" />
		</div>
	</div>
</body>
</html>