<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Of Students</title>
</head>
<body>
	<div align="center">
		<h1>Student DataBase</h1>
		<br>
	</div>
	<div align="center">
		<form:form modelAttribute="search">
			<br>
			Enter Name of Student to Search : 
			<form:input path="key" />
			<br>
			<form:errors path="key"/>
			
			<br><br>
			<button type="submit">Search</button><br> 
		</form:form>
	</div>
</body>
</html>