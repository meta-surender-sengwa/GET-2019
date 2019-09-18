<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Vehicle Registration</title>
</head>

<body>
	<div align="center">
		<div class="p-3 text-white jumbotron bg-primary " align="center">
			<h1 class="display-4">Meta-Parking</h1>
		</div>

		<div id="application">
			<h2 class="display-4">Vehicle Registration Form</h2>

			<div class="container d-flex justify-content-center p-2">
				<form:form modelAttribute="vehicle">
					<div class="form-group">
						<form:input path="vehicleName" class="form-control"
							placeholder="Vehicle Name" />
						<form:errors path="vehicleName" cssClass="text-danger" />
					</div><br>
					
					<div class="form-group">
						<form:select path="vehicleType" class="form-control">
							<form:option path="vehicleType" value="null">Choose Vehicle Type:</form:option>
							<form:option path="vehicleType" value="cycle">Cycle</form:option>
							<form:option path="vehicleType" value="bike">Bike</form:option>
							<form:option path="vehicleType" value="car">Car</form:option>

						</form:select>
						<form:errors path="vehicleType" cssClass="text-danger" />
					</div><br>

					<div class="form-group">
						<form:input path="vehicleNumber" class="form-control" type="text"
							placeholder="Vehicle Number" />
						<form:errors path="vehicleNumber" cssClass="text-danger" />
					</div><br>

					<div class="form-group">
						<form:input path="empId" class="form-control" type="number"
							placeholder="Employee Id" />
						<form:errors path="empId" cssClass="text-danger" />
					</div><br>
					
					<div class="form-group">
						<form:textarea rows="7" column="40" path="identification" class="form-control"
							type="text" placeholder="Identification" />
						<form:errors path="identification" cssClass="text-danger" />
					</div><br>
					
					<div class="form-group">
						<input size="40%" class="btn btn-primary form-control" name="submit"
							type="submit" value="Submit" />
					</div><br><br>	
				</form:form>
			</div>
		</div>
	</div>
	
	<div class="container" align="center">
		<button class="btn btn-primary"
			onclick="window.location.href='showProfile'">Show Profile</button>
	</div>
</body>
</html>