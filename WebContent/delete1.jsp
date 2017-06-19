<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.crud.dao.EmployeeDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Details</title>
</head>
<body>
<jsp:useBean id="emp" class="com.training.crud.bean.EmployeeBean"></jsp:useBean>
<jsp:setProperty property="id" name="emp"/>
<%
EmployeeDAO.deleteDetails(emp);
response.sendRedirect("view.jsp");
%>



</body>
</html>