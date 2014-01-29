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
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>Subject description</th>
				<th>Subject Name</th>
				<th>Delete subject </th>
				<th>Edit subject</th>
			</tr>
			<c:forEach items="${subjects}" var="subject">
				<tr>
					<td><input type="text" name="description/${subjects.indexOf(subject)}" value="${subject.description}"/></td>
					<td><input type="text" name="name/${subjects.indexOf(subject)}" value="${subject.name}" /></td>
					<td><input type="submit" name="action/delete/${subjects.indexOf(subject)}" value="delete"></td>
					<td><input type="submit" name="action/edit/${subjects.indexOf(subject)}" value="edit"></td>
				</tr>
				<input type="hidden" name="myObject" value="${subject.id}" />
			</c:forEach>
		</table>
	</form>
</body>
</html>