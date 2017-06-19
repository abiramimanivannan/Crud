package com.training.crud.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.crud.dao.EmployeeDAO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		int a=EmployeeDAO.deleteDetails1(id);
		if(a>0){
			writer.println("successfully deleted");
			RequestDispatcher dispatcher=req.getRequestDispatcher("delete.jsp");
			dispatcher.include(req, resp);
		}
		else{
			writer.println("sorry unable to delete record");
		}
	
	
	}
	
	

}
