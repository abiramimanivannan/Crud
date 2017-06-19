<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.crud.dao.EmployeeDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Details</title>
</head>
<body>
<jsp:useBean id="emp" class="com.training.crud.bean.EmployeeBean"></jsp:useBean>
<jsp:setProperty property="*" name="emp"/>
<%int i=EmployeeDAO.updateDetails(emp);
System.out.print(emp.getEmail());
if(i>0){
	response.sendRedirect("view.jsp");
}
else{
	out.println("<p>Not Updated....</p>");
}

%>
</body>
</html>