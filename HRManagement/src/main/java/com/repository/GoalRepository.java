package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.dto.GoalDetail;
import com.jdbc.JdbcUtill;

public class GoalRepository {
	public int save(GoalDetail GoalDetail) {
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "insert into Goal values(?,?,?,?)";
		int count=0;
		PreparedStatement ps = null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,GoalDetail.getEmployeeEmailid());
			ps.setString(2,GoalDetail.getGoalDescription());
			ps.setString(3,GoalDetail.getStartDate());
			ps.setString(4,GoalDetail.getEndDate());
			
			
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
	public List<GoalDetail>findAll(){
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "select * from Goal";
		Statement st =null;
		 List<GoalDetail> list=new ArrayList<>();
		try {
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
	    while(rs.next()) {
	    	   GoalDetail rd = new GoalDetail();
	    	   rd.setEmployeeEmailid(rs.getString("EmployeeEmailId"));
	    	   rd.setGoalDescription(rs.getString(" GoalDescription"));
	    	  
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
	

	

