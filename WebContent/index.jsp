<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<center>
<div class="tron"><h1>Add New Employees</h1></div>
<form action="AddServlet" method="post" style="background-color:orange; width:70%; padding:10px; margin:10px">
<table>
<tr><td>Id:</td><td><input type="text" name="id"/></td></tr>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"/></td></tr>
<tr><td>
Country:</td><td><select name="country">
<option>India</option>
<option>America</option>
<option>Chinna</option>
</select></td></tr>
<tr><td><input type="submit" style="background-color:yellow" value="Save Employee"/></td></tr>
</table>
</form>
</center>
<br><br>
<a href="view.jsp" class="btn btn-primary">View employees</a>
<a href="delete.jsp" class="btn btn-primary">Delete employees</a>
</div>
</body>
</html>