package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dto.LeaveDetail;

import com.mapper.LeaveMapper;

import com.service.LeaveService;
@WebServlet(" /leave.do")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveMapper LeaveMapper = new LeaveMapper();
		LeaveDetail LeaveDetail = LeaveMapper.mapToLeaveDetail(request);
		LeaveService Leaveservice = new LeaveService();
		int count = Leaveservice.save(LeaveDetail);
		
	    RequestDispatcher rd= request.getRequestDispatcher("success.html");
	    rd.forward(request, response);
	}

	



}



