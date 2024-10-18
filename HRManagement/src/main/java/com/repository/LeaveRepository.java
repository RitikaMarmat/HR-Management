package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.AttendanceDetail;
import com.dto.LeaveDetail;
import com.jdbc.JdbcUtill;

public class LeaveRepository {
	public int save(LeaveDetail LeaveDetail) {
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "insert into Leaves values(?,?,?,?)";
		int count=0;
		PreparedStatement ps = null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,LeaveDetail.getEmailId());
			ps.setString(2,LeaveDetail.getLeaveType());
			ps.setString(3,LeaveDetail.getStartDate());
			ps.setString(4,LeaveDetail.getEndDate());
			
			
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
	public List<LeaveDetail>findAll(){
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "select * from Leave";
		Statement st =null;
		 List<LeaveDetail> list=new ArrayList<>();
		try {
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
	    while(rs.next()) {
	    	   LeaveDetail rd = new LeaveDetail();
	    	   rd.setEmailId(rs.getString("EmailId"));
	    	   rd.setLeaveType(rs.getString("LeaveType"));
	    	  
	    	   rd.setStartDate(rs.getString("StartDate"));
	    	   rd.setEndDate(rs.getString("EndDate "));
	    	  
	    	  
	    	   list.add(rd);
	    	   
	    }
		} catch(SQLException e) {
	    	
	    }finally {
	    	JdbcUtill.cleanResources(st, con);
	    }
	    return list;
		}
	}
	

	



