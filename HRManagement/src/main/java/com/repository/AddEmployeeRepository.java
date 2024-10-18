package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.AddEmployee;
import com.jdbc.JdbcUtill;



public class AddEmployeeRepository {

public int save(AddEmployee AddEmployee) {
	Connection con =JdbcUtill.getMySqlConnection();
	String sql = "insert into employees values(?,?,?,?,?,?)";
	int count=0;
	PreparedStatement ps = null;
	
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1,AddEmployee.getUserName());
		ps.setString(2,AddEmployee.getEmailid());
		ps.setString(3,AddEmployee.getContactNumber());
		ps.setString(4,AddEmployee.getJobRole());
		ps.setString(5,AddEmployee.getPassword());
		ps.setString(6,AddEmployee.DateofJoining());
		
		 count = ps.executeUpdate();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		JdbcUtill.cleanResources(ps, con);
	}
	return count;
}
public int delete(String enrollmentNo) {
	Connection con =JdbcUtill.getMySqlConnection();
	String sql = "delete from employees where Emailid=?";
	int count=0;
	PreparedStatement ps = null;
	System.out.println("delete");
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1,enrollmentNo);
		
		
		 count = ps.executeUpdate();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		JdbcUtill.cleanResources(ps, con);
	}
	return count;
}
public List<AddEmployee>findAll(){
	Connection con =JdbcUtill.getMySqlConnection();
	String sql = "select * from employees";
	Statement st =null;
	 List<AddEmployee> list=new ArrayList<>();
	try {
		st=con.createStatement();
		ResultSet rs = st.executeQuery(sql);
    while(rs.next()) {
    	   AddEmployee rd = new AddEmployee();
    	   rd.setUserName(rs.getString("UserName"));
    	   rd.setEmailid(rs.getString("EmailId"));
    	   rd.setContactNumber(rs.getString("ContactNumber"));
    	   rd.setJobRole(rs.getString("JobRole"));
    	   rd.setDateofJoining(rs.getString("DateofJoining"));
    	   rd.setPassword(rs.getString("Password"));
    	  
    	   list.add(rd);
    	   
    }
	} catch(SQLException e) {
    	
    }finally {
    	JdbcUtill.cleanResources(st, con);
    }
    return list;
	}
}


