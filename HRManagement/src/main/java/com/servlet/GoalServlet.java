package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoalDetail;
import com.mapper.GoalMapper;
import com.service.GoalService;



@WebServlet("/goal.do")
public class GoalServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public GoalServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			GoalMapper GoalMapper = new GoalMapper();
			GoalDetail GoalDetail = GoalMapper.mapToGoalDetail(request);
			GoalService Goalservice = new GoalService();
			int count = Goalservice.save(GoalDetail);
			
		    RequestDispatcher rd= request.getRequestDispatcher("success.html");
		    rd.forward(request, response);
		}

		

	}


