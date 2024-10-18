package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DeleteEmployeeService;


@WebServlet("/delete.do")

	
	public class  DeleteEmployeeServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	   public DeleteEmployeeServlet() {
			// TODO Auto-generated constructor stub
		 
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println(request.getParameter("Emailid"));
			DeleteEmployeeService DeleteEmployeeservice = new DeleteEmployeeService();
			int count = DeleteEmployeeService.delete(request.getParameter("Emailid"));
			
		    RequestDispatcher rd= request.getRequestDispatcher("success.html");
		    rd.forward(request, response);
		}
	}





