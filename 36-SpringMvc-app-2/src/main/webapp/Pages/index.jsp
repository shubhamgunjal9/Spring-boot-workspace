<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<thead>
		<tr>
			<th>student id</th>
			<th>student name</th>
			<th>student contact</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${student}" var="student">
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.contact}</td>
		</tr>
		</c:forEach>
		
	</tbody>
</table>
<a href="/">go to home page</a>
</body>
</html>