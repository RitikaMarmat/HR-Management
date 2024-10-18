package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.DeleteEmployee;
import com.jdbc.JdbcUtill;

public class DeleteEmployeeRepository {
	public int save(DeleteEmployee DeleteEmployee) {
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "insert into Removetable values(?,?,?,?)";
		int count=0;
		PreparedStatement ps = null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,DeleteEmployee.getUserName());
			ps.setString(2,DeleteEmployee.getEmailid());
			ps.setString(3,DeleteEmployee.getContactNumber());
			ps.setString(4,DeleteEmployee.getPassword());
			
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
	public List<DeleteEmployee>findAll(){
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "delete from employees where UserName=? , Emailid=?,ContactNumber=?";
		Statement st =null;
		 List<DeleteEmployee> list=new ArrayList<>();
		try {
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
	    while(rs.next()) {
	    	   DeleteEmployee rd = new DeleteEmployee();
	    	   rd.setUserName(rs.getString("UserName"));
	    	   rd.setEmailid(rs.getString("Emailid"));
	    	   rd.setContactNumber(rs.getString("ContactNumber"));
	    	   rd.setPassword(rs.getString("Password"));
	    	  
	    	   list.add(rd);
	    	   
	    }
		} catch(SQLException e) {
	    	
	    }finally {
	    	JdbcUtill.cleanResources(st, con);
	    }
	    return list;
		}
	
	public int delete(String EmailId){
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "delete from employees where Emailid=?";
		Statement st =null;
		int count=0;
		try {
			st=con.createStatement();
			count = st.executeUpdate(sql);
	    }
		catch(SQLException e) {
			
	    	
	    }finally {
	    	JdbcUtill.cleanResources(st, con);
	    }
	    return count;
		}
	
}


