<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <h4>Error:${pageContext.exception.message}</h4>
       <h4>${pageContext.errorData.requestURI}</h4>
</body>
</html>