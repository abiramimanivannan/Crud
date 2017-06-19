package com.training.crud.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.crud.bean.EmployeeBean;
import com.training.crud.dao.EmployeeDAO;
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setId(id);
		employeeBean.setName(name);
		employeeBean.setPassword(password);
		employeeBean.setEmail(email);
		employeeBean.setCountry(country);
		
		int status=EmployeeDAO.addDetails(employeeBean);
		if(status>0){
			out.println("<p>Record saved successfully</p>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
			dispatcher.include(req, resp);
			
		}
		else{
			out.println("Sorry Unable to save record");
		}
		
		
		
	}

}
