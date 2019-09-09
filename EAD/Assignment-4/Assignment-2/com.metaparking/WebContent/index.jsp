<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Metacube Parking system</title>
</head>
<body>
<div align="right">
	<h2>
	<a href="http://localhost:8080/MetaParkingSystem/login.jsp">Login</a>
	</h2>
</div>
	<div align="center">
		<div>
			<h1>Metacube Parking system</h1>
		</div>
		<div id="application">
			<h2>Employee Registration form</h2>
			<%
				int count = 0;
				ArrayList<String> errorArray = new ArrayList<String>();
				if (request.getAttribute("Error") != null) {
					errorArray = (ArrayList<String>) request.getAttribute("Error");
					for (int i = 0; i < errorArray.size(); i++) {
						out.print("<h4 align='center' style='color:red;'>"
								+ errorArray.get(i) + "</h4>");
					}
				}
				if (request.getAttribute("Success") == "vinay") {
					out.print("<h4 align='center' style='color:blue;'>Your Account Created Succefully</h4>");
			%>

			<a href="http://localhost:8080/MetaParkingSystem/login.jsp">click
				here for Login</a>
			<%
				}
			%>

			<form action="UserRegistration" method="POST" name="RegForm"" >
				<span><input placeholder="Name" type="text" name="Name"></br>
					</br></span>
				<div>
					<input type="radio" id="male" name="gender" value="male" checked>
					<label for="male" id="male">Male</label> <input type="radio"
						id="female" name="gender" value="female"> <label
						for="female">Female</label>
				</div>
				<br> <span> <input placeholder="Email" name="Email"
					type="email"></br> </br></span> <span> <input
					placeholder="Contact Number" name="Contact" type="text"
					maxlength="10" size="20" size="10"></br> </br></span> <span>
					Organization :<br> <br> <select name="org_type"
					id="org_type">
						<option value="null">Choose organization</option>
						<option value="metacube">Metacube</option>
						<option value="tcs">Tcs</option>
						<option value="infosys">Infosys</option>
						<option value="samsung">Samsung</option>
						<option value="amazon">Amazon</option>
						<option value="microsoft">microsoft</option>

				</select>
				</span></br> </br> <span> <input type="password" placeholder="Password"
					name="Password" pattern=".{8,}"></br> </br></span> <span> <input
					type="password" placeholder="Confirm Password" name="Conpassword"></br>
					</br></span> <span> <input name="submit" type="submit" value="Submit"></br>
					</br></span>

			</form>

		</div>
	</div>
</body>
</html>