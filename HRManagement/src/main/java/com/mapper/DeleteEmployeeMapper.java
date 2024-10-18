package com.mapper;

import javax.servlet.http.HttpServletRequest;

import com.dto.DeleteEmployee;

public class DeleteEmployeeMapper {
	

	public DeleteEmployee mapToDeleteEmployee(HttpServletRequest request)
	{
		DeleteEmployee DeleteEmployee = new DeleteEmployee();
		DeleteEmployee.setUserName(request.getParameter("first_name"));
		DeleteEmployee.setEmailid(request.getParameter("email"));
		DeleteEmployee.setContactNumber(request.getParameter("contact_number"));
		
		DeleteEmployee.setPassword(request.getParameter("password"));
		
				return DeleteEmployee;
	}
}
