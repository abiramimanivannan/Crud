package com.training.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.crud.bean.EmployeeBean;

public class EmployeeDAO {
	
	
	public static Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
				return connection;
		
	}
	
	public static int addDetails(EmployeeBean employeeBean){
		Statement statement=null;
		int status=0;
		try {
			Connection con=EmployeeDAO.getConnection();
			statement=con.createStatement();
			String sql="insert into Employee values('"+employeeBean.getId()+"','"+employeeBean.getName()+"','"+employeeBean.getPassword()+"','"+employeeBean.getEmail()+"','"+employeeBean.getCountry()+"')";
			 status=statement.executeUpdate(sql);
			con.close();
			statement.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
		
		
		
	}
	public static int updateDetails(EmployeeBean employeeBean){
		Statement statement=null;
		int status=0;
		try {
			Connection con=EmployeeDAO.getConnection();
			statement=con.createStatement();
			String sql="update Employee set id='"+employeeBean.getId()+"',name='"+employeeBean.getName()+"',password='"+employeeBean.getPassword()+"',email='"+employeeBean.getEmail()+"',country='"+employeeBean.getCountry()+"'where id="+employeeBean.getId();
	
			status=statement.executeUpdate(sql);
			con.close();
			statement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
		
		
	}
	
	public static int deleteDetails(EmployeeBean employeeBean){
		
		int status=0;
		try {
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement("delete from Employee where id=?");
			preparedStatement.setInt(1, employeeBean.getId());;
			status=preparedStatement.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
			
		
	}
	
	
	public static int deleteDetails1(int id){
		int status=0;
		try {
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement("delete from Employee where id=?");
			preparedStatement.setInt(1, id);;
			status=preparedStatement.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
		
	}
	
	public static EmployeeBean selectDetails(int id){
		
		EmployeeBean employeeBean=new EmployeeBean();
		ResultSet resultSet=null;
		try {
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement("select * from Employee where id =?");
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				employeeBean.setId(resultSet.getInt(1));
				employeeBean.setName(resultSet.getString(2));
				employeeBean.setPassword(resultSet.getString(3));
				employeeBean.setEmail(resultSet.getString(4));
				employeeBean.setCountry(resultSet.getString(5));
				
			}
			con.close();
			resultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeBean;
		
		
	}
	
	public static List<EmployeeBean> getAllEmployees(){
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			Connection con=EmployeeDAO.getConnection();
			statement=con.createStatement();
			String sql="select * from Employee";
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()){
				EmployeeBean employeeBean=new EmployeeBean();
				employeeBean.setName(resultSet.getString("Name"));
				employeeBean.setPassword(resultSet.getString("Password"));
				employeeBean.setEmail(resultSet.getString("Email"));
				employeeBean.setCountry(resultSet.getString("Country"));
				employeeBean.setId(resultSet.getInt("Id"));
				list.add(employeeBean);
			}
			con.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
		
		
		
		
		
	}
	

}
