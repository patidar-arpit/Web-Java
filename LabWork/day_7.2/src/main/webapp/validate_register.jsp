<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:setProperty property="*" name="user"/>
<h4>${sessionScope.user.voterRegistration()}</h4>
<body>
  
</body>
</html>