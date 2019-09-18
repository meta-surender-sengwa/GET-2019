<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Pass</title>
</head>
<body>
	<div class="p-3 text-white jumbotron bg-primary " align="center">
		<h1 class="display-4">Parking Pass Granted</h1>
	</div>

	<div class="container p-5" align="center">
		<form:form>
			<h3 class="display-4">Grand Total : ${passPrice}</h3>
		</form:form>
	</div><br><br>
	
	<div class="container" align="center">
		<input type="button" class="btn btn-primary " value="Show Profile"
			onClick="window.location.href='showProfile'" />
	</div>
</body>
</html>