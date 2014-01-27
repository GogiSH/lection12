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
	<table border="1">
		<tr>
			<th>Subject description</th>
			<th>Subject Name</th>
		</tr>
		<c:forEach items="${subjects}" var="subject">
			<tr>
				<td><c:out value="${subject.description}" /></td>
				<td><c:out value="${subject.name}" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>Edit will be added soon...</h1>
</body>
</html>