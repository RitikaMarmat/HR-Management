package com.mapper;

import javax.servlet.http.HttpServletRequest;

import com.dto.LoginDetail;

public class LoginMapper {
	public LoginDetail mapToLoginDetail(HttpServletRequest request)
	{
		LoginDetail logindetail = new LoginDetail();
		logindetail.setUsername(request.getParameter("username"));
		logindetail.setPassword(request.getParameter("password"));
		return logindetail;
	}

	
}
