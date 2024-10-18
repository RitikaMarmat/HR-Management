package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtill {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch ( ClassNotFoundException e ) {
			System.out.println("Driver is not loaded");
		}
	}

	public static Connection getMySqlConnection() {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/HR";
			con = DriverManager.getConnection(url, "root", "Meena@123");

		} catch ( SQLException e ) {
			System.out.println("Exception occurs while establishing the connection");
		}
		return con;
	}

	public static void cleanResources(Statement st, Connection con) {

		try {
			if ( st != null )
				st.close();
			if ( con != null )
				con.close();
		} catch ( SQLException e ) {
			System.out.println("Something went wrong while closing the connection");
		}
	}

	public static void cleanResources(Statement st, Connection con, ResultSet rs) {

		try {
			cleanResources(st, con);
				con.close();
			if ( rs != null )
				rs.close();
		} catch ( SQLException e ) {
			System.out.println("Something went wrong while closing the connection");
		}
	}
}
