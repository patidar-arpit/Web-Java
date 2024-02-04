<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!   
     String msg = "Hellooo";
%>
<body>
        <%
         int result = 10/5;
        String anotherMsg = "anotherHello";
        pageContext.setAttribute("pass", 1234);
        %>
        <%@  include file="test2.jsp" %>   
        
         
        <h4>Result :<%= result %></h4>
        
        
        
        
</body>
</html>