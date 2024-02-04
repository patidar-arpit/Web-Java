<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="pojos.*"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
            

              <h3>Logged in.!!</h3>
              <h5>Validated User Details : ${sessionScope.user}</h5>
               <h2>Email:${sessionScope.user.email}</h2>
               
               <%  
                     session.invalidate();
                %>
          
</body>
</html>