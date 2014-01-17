<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Info Page</title>
	</head>
	<body>
		<h1>User Info Page</h1>
		<% System.out.println("ALWAYS DELETE SCRIPLET CRAP FROM YOUR PAGE!!!");		%>
		
		<form action="./user" method="POST">
			<table> 
				<tr> 
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th> 
					<th>Password</th> 
				</tr>
				<tr>
					<td><input type="text" name="firstName" value="${user.firstName}"></td>
					<td><input type="text" name="lastName" value="${user.lastName}"></td>
					<td><input type="text" name="email" value="${user.email}"></td>
					<td><input type="text" name="pass" value="${user.password}"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" name="action" value="Add"/>
						<input type="submit" name="action" value="Delete"/>
						<!-- input type="submit" name="action" value="Search"/ -->
					</td>
				</tr>
			</table>	
		</form>
		
	</body>
</html>