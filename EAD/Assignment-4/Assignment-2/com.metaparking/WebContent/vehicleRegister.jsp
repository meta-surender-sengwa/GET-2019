<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right">
<h3>
<a href=gatePass.jsp>Take Gate Pass</a><br><br>
<a href=ShowFriends>Show Friend List</a>
</h3>
</div>
<div align="center">
	<h2>
			Vehicle registration form
		</h2>
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
					out.print("<h4 align='center' style='color:blue;'>Your Vehicle Registered Succefully</h4>");
			%>
			<%
				}
			%>
		<form action="VehicleRegistration" method="POST" name="vehicleform" >
			<span> <input placeholder="Vehicle Name" name="vname" type="text" ></br><br></span>
			<span> Choose Vehicle Type:<br><br>
				<select id="vehicle_type" name="vehicleType">
					<option value="cycle">Cycle</option>
					<option value="bike">Bike</option>
					<option value="car">Car</option>

				</select>
			</span></br></br>
			<span> <input placeholder="Vehicle Number" name="number" type="text" required></br></br></span>
			<span> <input placeholder="EmployeeId" type="number" name="empid" required></br></br></span>
			<span><textarea rows="5" cols="20" placeholder="Identification" name="identy"></textarea><br><br></span>

			<span> <input type="submit" value="Submit" ></br></span>

		</form>
</div>
</body>
</html>