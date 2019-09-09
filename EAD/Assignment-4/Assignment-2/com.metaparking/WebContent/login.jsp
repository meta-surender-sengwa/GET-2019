<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	
	<h1>Welcome!! Login here</h1>
	${AuthenicationFailed}
		<form action="Login" method="POST" name="loginForm"" >
			<br> <span> <input placeholder="Email" name="Email"
				type="email"></br> </br></span>
				 <span> <input type="password" placeholder="Password"
				name="Password" ></br> </br></span> 
				<span> 
				<input
				name="submit" type="submit" value="Submit"></br> </br>
				</span>

		</form>

	</div>

</body>
</html>