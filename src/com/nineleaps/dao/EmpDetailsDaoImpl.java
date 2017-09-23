package com.nineleaps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.nineleaps.bean.Bean;
import com.nineleaps.bean.Node;
import com.nineleaps.dbutil.dbUtil;

public class EmpDetailsDaoImpl {
	public static boolean enterEmpDetails(Bean getbean){
		boolean flag=false;
		String query="insert into employee_details values(?,?,?)";

		try {
			Connection conn = dbUtil.getConnection();

			PreparedStatement pstm = conn.prepareStatement(query);

			pstm.setString(1, getbean.getName());
			pstm.setString(2, getbean.getDesignation());
			pstm.setString(3, getbean.getManager());
			int status = pstm.executeUpdate();
			if(status==1){
				System.out.println("Record inserted");
				flag=true;
			}
			else
			{System.out.println("Record not inserted");
			flag=false;}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static ArrayList fetchEmpDetails(){

		ArrayList<Bean> list = new ArrayList<Bean>();
		String query="select * from employee_details";
		Connection conn;
		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet res = pstm.executeQuery();
			while (res.next()){
				Bean bean = new Bean();
				bean.setName(res.getString("name"));

				bean.setDesignation(res.getString("designation"));
				bean.setManager(res.getString("manager"));

				list.add(bean);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list;

	}
	public static ArrayList fetchManager(){

		ArrayList<String> list = new ArrayList<String>();
		String query="select distinct * from employee_details";
		Connection conn;
		String name = null;

		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstm = conn.prepareStatement(query);

			ResultSet res = pstm.executeQuery();
			while (res.next()){
				name = (res.getString("name"));

				list.add(name);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	public static boolean updateDetails(Bean getbean,String name){
		boolean flag=false;
		String query="update employee_details set name=?,designation=?,manager=? where name=?";

		try {
			Connection conn = dbUtil.getConnection();

			PreparedStatement pstm = conn.prepareStatement(query);

			pstm.setString(1, getbean.getName());
			pstm.setString(2, getbean.getDesignation());
			pstm.setString(3, getbean.getManager());
			pstm.setString(4, name);
			int status = pstm.executeUpdate();
			if(status==1){
				System.out.println("Record updated");
				flag=true;
			}
			else
			{System.out.println("Record not updated");
			flag=false;}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}
	public static ArrayList<Bean> EmployeeManager(){
		String query="select m.name,m.manager,m.designation from employee_details m,employee_details e where m.manager=e.name and e.designation<>'CEO' order by e.name";

		ArrayList<Bean> list = new ArrayList<Bean>();

		Connection conn;
		try {
			conn = dbUtil.getConnection();

			Statement pstm = conn.createStatement();
			ResultSet result = pstm.executeQuery(query);
			while (result.next()){
				Bean bean = new Bean();
				bean.setName(result.getString("name"));
				bean.setManager(result.getString("manager"));
				bean.setDesignation(result.getString("designation"));
				list.add(bean);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;


	}
	public static ArrayList<Bean> EmployeeCEO(){

		String query="select * from employee_details where manager is null";  
		Bean bean = new Bean();

		ArrayList<Bean> list = new ArrayList<Bean>();

		Connection conn;
		try {
			conn = dbUtil.getConnection();

			Statement pstm = conn.createStatement();
			ResultSet result = pstm.executeQuery(query);
			while (result.next()){
				bean.setName(result.getString("name"));
				bean.setManager(result.getString("manager"));
				bean.setDesignation(result.getString("designation"));
				list.add(bean);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;


	}
	public static ArrayList<Bean> EmployeeManagerwithCeo(){
		String query="select m.name,m.manager,m.designation from employee_details m,employee_details e where m.manager=e.name and e.designation='CEO' order by e.name";



		ArrayList<Bean> list = new ArrayList<Bean>();

		Connection conn;
		try {
			conn = dbUtil.getConnection();

			Statement pstm = conn.createStatement();
			ResultSet result = pstm.executeQuery(query);
			while (result.next()){
				Bean bean = new Bean();
				bean.setName(result.getString("name"));
				bean.setManager(result.getString("manager"));
				bean.setDesignation(result.getString("designation"));
				list.add(bean);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;


	}
}
