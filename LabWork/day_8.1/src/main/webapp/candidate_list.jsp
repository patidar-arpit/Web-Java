<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>In candidate list page....</h4>
	<h5>Hello , ${sessionScope.user.userDetails.firstName}
		${sessionScope.user.userDetails.lastName}, logged in under
		${sessionScope.user.userDetails.role} role</h5>
</body>
</html>