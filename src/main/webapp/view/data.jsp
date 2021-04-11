<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><a href="/">Add Employee Data</a></h1>
<h1 style="color: Green; text-align: center">${msg }</h1>
<table border="1" rules="all"style="background-color: cyan">
	
		
	<tbody>
		<c:forEach items="${value}" var="v" >
			<tr>
				<td>Employee ID::</td><td>${v.empId }</td></tr>
				<td>Employee Name::</td><td>${v.empName }</td></tr>
				<td>Employee designation::</td><td>${v.empDegination }</td></tr>
				<td>Employee Date Of Joining::</td><td>${v.empDoj }</td></tr>
				
				
				
			
		</c:forEach>
	</tbody>

</table></center>

</body>
</html>