package com.service;

import com.dto.LoginDetail;
import com.factory.LoginFactory;
import com.repository.LoginRepository;

public class LoginService {
	public String validateUser(LoginDetail loginDetail) {
		LoginRepository repository = LoginFactory.createLoginRepositoryInstance();
		LoginDetail result = repository.fetchLoginDetail(loginDetail);
		String message="Invalid username and password";
		if(result!=null&&loginDetail.getPassword().equals(result.getPassword()))
		{
			message="login successfully";
		}
		return message;
	}
}
