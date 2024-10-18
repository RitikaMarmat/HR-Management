package com.factory;

import com.mapper.LoginMapper;
import com.repository.LoginRepository;
import com.service.LoginService;

public class LoginFactory {
	public static LoginMapper createLoginMapperInstance() {
		return new LoginMapper();
	   }
	   public static LoginService createLoginServiceInstance() {
		   return new LoginService();
	   }
	   public static LoginRepository createLoginRepositoryInstance() {
		   return new LoginRepository();
	   }
	

}
