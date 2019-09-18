<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Employee Registration</title>
</head>

<body>
	<div align="center">
		<div class="p-3 text-white jumbotron bg-primary " align="center">
			<h1 class="display-4">Meta-Parking</h1>
		</div>
		
		<div id="application">
			<h2 class="display-4">Employee Registration form</h2>
		
			<div class="container d-flex justify-content-center p-2">
				<form:form modelAttribute="employee">
					<div class="form-group">
						<form:input size="40%" path="fullname" class="form-control"
							placeholder="Name" type="text" id="name" name="Name" />
						<form:errors path="fullname" cssClass="text-danger" />
					</div><br>

					<div class="form-group">
						<form:label path="gender">Select Gender</form:label>
						<form:radiobutton path="gender" id="male" name="gender"
							value="male" checked="true" />
						<form:label path="gender" for="male" id="male">Male</form:label>
						<form:radiobutton path="gender" id="female" name="gender"
							value="female" />
						<form:label path="gender" for="female">Female</form:label>
						<form:errors path="gender" cssClass="text-danger" />
					</div><br>
					
					<div class="form-group">
						<form:input size="40%" path="email" class="form-control" placeholder="Email"
							name="Email" type="email" />
						<form:errors path="email" cssClass="text-danger" />
					</div><br>

					<div class="form-group">
						<form:input size="40%" path="contact" class="form-control"
							placeholder="Contact Number" />
						<form:errors path="contact" cssClass="text-danger" />
					</div><br>

					<div class="form-group">
						<form:select path="organisation" class="form-control"
							name="org_type" id="org_type">
							<form:option path="organisation" value="null">Choose organization</form:option>
							<form:option path="organisation" value="metacube">Metacube</form:option>
							<form:option path="organisation" value="tcs">Tcs</form:option>
							<form:option path="organisation" value="infosys">Infosys</form:option>
							<form:option path="organisation" value="samsung">Samsung</form:option>
							<form:option path="organisation" value="amazon">Amazon</form:option>
							<form:option path="organisation" value="microsoft">microsoft</form:option>

						</form:select>
						<form:errors path="organisation" cssClass="text-danger" />
					</div><br>
					
					<div class="form-group">
						<form:input size="40%" path="password" class="form-control" type="password"
							placeholder="Password" name="Password" pattern=".{8,}" />
						<form:errors path="password" cssClass="text-danger" />
					</div><br>
					
					<div class="form-group">
						<form:input size="40%" path="confirmPassword" class="form-control"
							type="password" placeholder="Confirm Password" />
						<form:errors path="confirmPassword" cssClass="text-danger" />
					</div><br>
					
					<div class="form-group">
						<input class="btn btn-primary form-control" name="submit"
							type="submit" value="Submit" />
					</div><br><br>
				</form:form>
			</div>
		</div>
	</div>
	
	<div align="center">
		<p>If Already Registered, then Login into your account !!</p>
		<input type="button" class="btn btn-primary " value="Login"
			onClick="window.location.href='home'" />
	</div>
</body>
</html>