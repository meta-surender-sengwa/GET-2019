<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Login Page</title>
</head>
<body>
<div align="center">
	<h1>Student DataBase</h1>
	<br>
	<h2>Login</h2>
	<form action="/login"  method="POST">
		<h4 class="text-danger">${errorMsg}</h4>
			User:
			<input type='text' name='username' placeholder="enter user email">
			<br/><br/>
			
			Password:
			<input type='password' name='password' placeholder="enter your password">
			<br/><br/>
			<input type="submit" name="submit" value="Submit" />
	</form>
</div>
</body>
</html>