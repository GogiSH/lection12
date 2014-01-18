<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Teacher Info Page</title>
</head>
<body>
	<h1>List Teachers: </h1>	
	<table> 
		<tr> 					
			<th>User e-mail</th> 
			<th>Teacher experience</th> 
		</tr>
		<c:forEach var="teacher" items="${teachers}">
			<tr>
				<td>${teacher.user.email}</td>
				<td>${teacher.experience}</td>
			</tr>
		</c:forEach>
	</table>
	
	<p>Before registration teacher, please 
	<a href="user.jsp"> create new user</a>	
	</p>
	
	
	<form action="./teacherSavchenko" method="POST">
			<table> 
				<tr> 					
					<th>User e-mail</th> 
					<th>Teacher experience</th> 
				</tr>
				<tr>					
					<td><input type="text" name="email" value="${user.email}"></td>
					<td><input type="text" name="experience" value="${teacher.experience}"></td>
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
		
		<p> 
		<a href="teacherSavchenko"> Go to servlet</a>	
		</p>
		
		<h4>by: Savchenko Alex </h4>
</body>
</html>