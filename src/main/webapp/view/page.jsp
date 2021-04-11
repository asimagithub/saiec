<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>
<a href="/find"><h1>Get Data</h1></a>
<a href="/delete"><h1>Delete Data</h1></a>

	
	<form action="/register" method="post" enctype="multipart/form-data">
  <label for="myfile">Select a file:</label>
  <input type="file" id="myfile" name="myfile"><br><br>
  <input type="submit">
</form>
</body>
</html>