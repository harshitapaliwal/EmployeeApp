package com.nineleaps.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nineleaps.bean.Bean;
import com.nineleaps.bean.Node;
import com.nineleaps.dao.EmpDetailsDaoImpl;
import com.nineleaps.dbutil.dbUtil;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processrequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processrequest(request,response);			  
	}
	protected void processrequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		switch(action){

		case "table_view":{

			ArrayList<Bean> list = EmpDetailsDaoImpl.fetchEmpDetails();
			int count=0;

			request.setAttribute("empList", list);
			request.setAttribute("count", count);

			RequestDispatcher dispatcher = request.getRequestDispatcher("tableView.jsp");
			dispatcher.forward(request, response);		
			break;
		}
		case "enter_details":{
			String name=request.getParameter("name");
			String designation=request.getParameter("designation");
			String manager=request.getParameter("manager");

			Bean bean = new Bean();
			bean.setName(name);
			bean.setDesignation(designation);
			bean.setManager(manager);

			boolean flag=false;
			flag=EmpDetailsDaoImpl.enterEmpDetails(bean);

			request.setAttribute("emp_name", bean.getName());
			request.setAttribute("emp_designation", bean.getDesignation());
			request.setAttribute("emp_manager", bean.getManager());
			RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
			dispatcher.forward(request, response);	
			break;
		}
		case "fetch_manager":{
			ArrayList<String> list = EmpDetailsDaoImpl.fetchManager();

			request.setAttribute("manager_list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("enterDetails.jsp");
			dispatcher.forward(request, response);		
			break;
		}
		case "show":{

			String emp_name = request.getParameter("emp_name");
			String emp_designation = request.getParameter("emp_designation");
			String emp_manager = request.getParameter("emp_manager");

			request.setAttribute("emp_manager", emp_manager);
			request.setAttribute("emp_name", emp_name);
			request.setAttribute("emp_designation", emp_designation);

			RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
			dispatcher.forward(request, response);		
			break;
		}
		case "edit":{

			String emp_name = request.getParameter("emp_name");
			String emp_designation = request.getParameter("emp_designation");
			String emp_manager = request.getParameter("emp_manager");
			ArrayList<String> list = EmpDetailsDaoImpl.fetchManager();

			request.setAttribute("emp_name", emp_name);
			request.setAttribute("emp_designation", emp_designation);
			request.setAttribute("emp_manager", emp_manager);
			request.setAttribute("manager_list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);		
			break;
		}
		case "update":{
			Bean bean = new Bean();
			String emp_name = request.getParameter("emp_name");

			String emp_designation = request.getParameter("emp_designation");

			String emp_manager = request.getParameter("emp_manager");
			bean.setName(request.getParameter("name"));
			bean.setDesignation(request.getParameter("designation"));
			bean.setManager(request.getParameter("manager"));
			boolean flag =false;

			flag=EmpDetailsDaoImpl.updateDetails(bean, emp_name);

			request.setAttribute("emp_name", bean.getName());
			request.setAttribute("emp_designation", bean.getDesignation());
			request.setAttribute("emp_manager", bean.getManager());
			RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
			dispatcher.forward(request, response);
		}
		case "list_view":{
			ArrayList<Bean> list = EmpDetailsDaoImpl.EmployeeManager();
			ArrayList<Bean> ceo_list = EmpDetailsDaoImpl.EmployeeCEO();
			ArrayList<Bean> ceo_Manager_list = EmpDetailsDaoImpl.EmployeeManagerwithCeo();
			request.setAttribute("ceo_List", ceo_list);
			request.setAttribute("emp_List", list);
			request.setAttribute("ceo_Manager_List", ceo_Manager_list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("listView.jsp");
			dispatcher.forward(request, response);		
			break;
		}

		}			  
	}

}
