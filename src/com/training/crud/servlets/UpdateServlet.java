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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		System.out.println(name);
		
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setId(id);
		employeeBean.setName(name);
		employeeBean.setPassword(password);
		employeeBean.setEmail(email);
		employeeBean.setCountry(country);
		
		int a=EmployeeDAO.updateDetails(employeeBean);
		if(a>0){
			writer.println("Successfully updated");
			RequestDispatcher dispatcher=req.getRequestDispatcher("update.jsp");
			dispatcher.include(req, resp);
		}
		else{
			writer.println("sorry unable to update record");
		}
		
		
	}
	

}
