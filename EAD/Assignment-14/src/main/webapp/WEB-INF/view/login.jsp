<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Login Page</title>
</head>

<body>
	<section align="center">
		<c:if test="${not empty errorMsg}">
			<div>
				<button type="button"><span>x</span></button>
				<strong>${errorMsg}</strong>
			</div>
		</c:if>
		
		<div><h1>Login</h1></div>
		
		<div>
			<form action="/login" method="post">
				<div><input type="text" placeholder="username" id="username" name="username"></div>
				<div><input type="password" placeholder="password" id="password" name="password"></div>
				<div><input type="submit" value="login"></div>
			</form>
		</div>
	</section>
</body>
</html>