<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>



<body>

     <h3 style="color:red">${sessionScope.player.err}</h3>
	<form action="add" method="post">
		<table style="background-color: lightgrey; margin: auto">
			
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="ln" /></td>
			</tr>
			
			<tr>
				<td>Enter city Name</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>Enter company Name</td>
				<td><input type="text" name="company" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form>
	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>