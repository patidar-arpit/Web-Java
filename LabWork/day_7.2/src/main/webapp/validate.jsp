<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
   <%--//creating the bean instance --%>
 
 <jsp:setProperty property="*" name="user"/>
 
 <h4>${sessionScope.user.authenticateUser()}</h4>
 
<body>

</body>
</html>