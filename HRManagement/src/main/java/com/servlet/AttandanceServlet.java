package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AttendanceDetail;

import com.mapper.AttendanceMapper;

import com.service.AttendanceService;

@WebServlet("/attendance.do")
public class AttandanceServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public AttandanceServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AttendanceMapper AttendanceMapper = new AttendanceMapper();
			AttendanceDetail AttendanceDetail = AttendanceMapper.mapToAttendanceDetail(request);
			AttendanceService AttendanceService = new AttendanceService();
			int count = AttendanceService.save(AttendanceDetail);
			
		    RequestDispatcher rd= request.getRequestDispatcher("success.html");
		    rd.forward(request, response);
		}

		

	}




