<%@page import="java.util.HashMap"%>
<%@page import="pojos.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
		<%!  
		      HashMap<String,User> userMap = new HashMap<>();
		       
	        	public void jspInit() {
			           userMap.put("arpit@123", new User("arpit@123","arpit#123",24));
			           userMap.put("bittu@123", new User("vittu@123","bittu#123",24));

		     	}		
		%>


<body>

     <%
            String email = request.getParameter("em");
            String pass = request.getParameter("pass");
            int age =  Integer.parseInt(request.getParameter("age"));
            
            if(userMap.containsKey(email)){
            	if(userMap.get(email).getPassword().equals(pass)){
            		session.setAttribute("user", new User(email,pass,age));
            		response.sendRedirect("detail.jsp");
            	}
            	else{
            		 %>
            		 <h4 style="color:red">Invalid Password</h4>
            		 <h3><a href="login.jsp">Pleas try again</a></h3>
              <% 
            	}
            }
            else{
            	     response.sendRedirect("register.jsp");	   
            }
     %>
         
</body>
</html>