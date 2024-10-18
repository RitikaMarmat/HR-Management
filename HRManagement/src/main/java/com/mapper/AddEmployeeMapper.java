package com.mapper;


import javax.servlet.http.HttpServletRequest;

import com.dto.AddEmployee;


public class AddEmployeeMapper {
	

	public AddEmployee mapToAddEmployee(HttpServletRequest request)
	{
		AddEmployee AddEmployee = new AddEmployee();
		AddEmployee.setUserName(request.getParameter("first_name"));
		AddEmployee.setEmailid(request.getParameter("email"));
		AddEmployee.setContactNumber(request.getParameter("contact_number"));
		AddEmployee.setJobRole(request.getParameter("job_role"));
		AddEmployee.setPassword(request.getParameter("password"));
		AddEmployee.setDateofJoining(request.getParameter("date_of_joining"));
				return AddEmployee;
	}
}

