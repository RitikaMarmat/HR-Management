package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AddEmployee;
import com.mapper.AddEmployeeMapper;
import com.service.AddEmployeeService;
@WebServlet("/add.do")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		AddEmployeeMapper AddEmployeeMapper = new AddEmployeeMapper();
		AddEmployee  AddEmployee = AddEmployeeMapper.mapToAddEmployee(request);
		AddEmployeeService AddEmployeeService = new AddEmployeeService();
		int count = AddEmployeeService.save(AddEmployee);
		
	    RequestDispatcher rd= request.getRequestDispatcher("success.html");
	    rd.forward(request, response);
	}

 

}
