<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Get Your Vehicle Pass</title>
</head>
<body>
	<div class="p-3 mb-2 bg-primary text-white jumbotron" align="center">
		<h1 class="display-4">Choose Your Pass!!</h1>
	</div>
	
	<div class="container p-2" align='center'>
		<form:form modelAttribute="pass" action="/getPass">
			<p>Select Plans in (USD)</p>
			<div class="form-group">
				<form:select path="plan" class="form-control">
					<form:options items="${passPrices}" />
				</form:select>
				<form:errors path="plan" />
			</div><br>

			<p>Select Currency</p>
			<div class="form-group">
				<form:select path="currency" align='center' class="form-control ">
					<form:option value="USD">USD</form:option>
					<form:option value="INR">INR</form:option>
					<form:option value="YEN">YEN</form:option>
				</form:select>
			</div><br>
			
			<input class="btn btn-primary" type='submit' value='GetPass' />
		</form:form>
	</div>
</body>
</html>