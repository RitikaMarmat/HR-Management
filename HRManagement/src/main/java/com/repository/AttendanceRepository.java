package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.AttendanceDetail;

import com.jdbc.JdbcUtill;

public class AttendanceRepository {
	public int save(AttendanceDetail AttendanceDetail) {
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "insert into Attendance values(?,?,?,?)";
		int count=0;
		PreparedStatement ps = null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,AttendanceDetail.getEmployeeName());
			ps.setString(2,AttendanceDetail.getEmployeeEmailid());
			ps.setString(3,AttendanceDetail.getDate());
			ps.setString(4,AttendanceDetail.getTime());
			
			
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
	public List<AttendanceDetail>findAll(){
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "select * from Attendance";
		Statement st =null;
		 List<AttendanceDetail> list=new ArrayList<>();
		try {
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
	    while(rs.next()) {
	    	   AttendanceDetail rd = new AttendanceDetail();
	    	   rd.setEmployeeName(rs.getString("EmployeeName"));
	    	   rd.setEmployeeEmailid(rs.getString("EmployeeEmailId"));
	    	  
	    	   rd.setDate(rs.getString("Date"));
	    	   rd.setTime(rs.getString("Time "));
	    	  
	    	  
	    	   list.add(rd);
	    	   
	    }
		} catch(SQLException e) {
	    	
	    }finally {
	    	JdbcUtill.cleanResources(st, con);
	    }
	    return list;
		}
	}
	

	

