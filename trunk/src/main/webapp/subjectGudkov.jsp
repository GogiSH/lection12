<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><a href="./subjectGudkov">Use the following page to interact with the Subjects</a></p>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th><input type="text" size="35" value="Subject description"></th>
				<th><input type="text" size="35" value="Subject Name"></th>
				<th><input type="text" value="Delete subject"> </th>
				<th><input type="text" value="Edit subject"></th>
			</tr>
			
			<c:forEach items="${subjects}" var="subject">

				<tr>
				
					<td><input type="text" size="35" name="description/${subject.id}" value="${subject.description}"/></td>
					<td><input type="text" size="35" name="name/${subject.id}" value="${subject.name}" /></td>
					<td><input type="submit"  name="action" value="delete/${subject.id}"></td>
					<td><input type="submit"  name="action" value="edit/${subject.id}"></td>
				</tr>
			</c:forEach>
		</table>
		
		<table border="1">
		<tr>		
		<td><input type="text" placeholder="Insert here subject description" size="35" name="description" /></td>
		<td><input type="text" placeholder="Insert here subject name" size="35" name="name"/></td>
		<td><input type="submit" name="action" value="add"></td>
		<td><input type="reset"  value="reset"></td>
		</tr>
		</table>
	</form>
</body>
</html>