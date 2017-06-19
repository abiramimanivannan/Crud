<%@page import="com.training.crud.dao.EmployeeDAO"%>
<%@page import="com.training.crud.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body>

<%
String id=request.getParameter("id");
EmployeeBean employeeBean=EmployeeDAO.selectDetails(Integer.parseInt(id));

%>
<center>
<form action="update.jsp" method="get">
Id:<input type="text" name="id" value="<%= employeeBean.getId() %>"/><br>
Name:<input type="text" name="name" value="<%= employeeBean.getName() %>"/><br>
Password:<input type="password" name="password" value="<%= employeeBean.getPassword() %>"/><br>
Email:<input type="text" name="email" value="<%= employeeBean.getEmail() %>"/><br>
Country:<input type="text" name="country" value="<%= employeeBean.getCountry() %>"/><br>
<input type="submit" value="Update" class="btn btn-success"/>
</form>



</center>
</body>
</html>