package com.training.crud.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.crud.bean.EmployeeBean;
import com.training.crud.dao.EmployeeDAO;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<EmployeeBean> list=EmployeeDAO.getAllEmployees();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("view.jsp");
			dispatcher.include(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
	}

}
