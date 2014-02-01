<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Blagodarev Page</h1>
	<form action="./studentBlagodarev" method="POST">
		<table border="1">
			<tr>
				<th colspan="3">StudentNo</th>
			<tr>
				<td colspan="3"><input type="text" name="studentNo"	value="${student.studentNo}" /></td>
			</tr>
			<tr>
				<th>Student id</th>
				<th>Student NO</th>
				<th>User email</th>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.studentNo}</td>
					<td>${student.user.email}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">
					<input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="Delete" /> 
					<input type="submit" name="action" value="Search" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>