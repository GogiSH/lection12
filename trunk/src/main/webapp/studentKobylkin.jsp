<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
		<table border="1">
			<tr>
				<th>Student Number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.studentNo}</td>
					<td>${student.user.firstName}</td>
					<td>${student.user.lastName}</td>
					<td>${student.user.email}</td>
				</tr>
			</c:forEach>
		</table>
	
	<form action="./studentKobylkin" method="POST">
			<table> 
				<tr> 
					<th>Email</th> 					
					<th>Student Number</th> 
				</tr>
				<tr>
					<td><input type="text" name="email" value="${student.user.email}"></td>
					<td><input type="text" name="studentNumber" value="${student.studentNo}"></td>					
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" name="action" value="Add"/>
						<input type="submit" name="action" value="Delete"/>
					</td>
				</tr>
			</table>	
		</form>
</body>
</html>