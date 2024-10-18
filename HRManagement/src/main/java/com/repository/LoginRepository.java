package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.LoginDetail;
import com.jdbc.JdbcUtill;

public class LoginRepository {
	public LoginDetail fetchLoginDetail(LoginDetail loginDetail) {
		Connection con =JdbcUtill.getMySqlConnection();
		String sql = "select * from login_detail where username=? and password=?";
		LoginDetail result=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			System.out.println(loginDetail.getUsername());
			ps=con.prepareStatement(sql);
			ps.setString(1,loginDetail.getUsername());
			ps.setString(2,loginDetail.getPassword());
			rs=ps.executeQuery();
			rs.next();
			result = new LoginDetail();
			System.out.println(rs.getString(1));
			result.setUsername(rs.getString(1));
			result.setPassword(rs.getString(2));
			return result;
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong while fetching data ");
			return result;
		}
		finally {
			JdbcUtill.cleanResources(ps, con, rs);
		}
	}

	
 
}
