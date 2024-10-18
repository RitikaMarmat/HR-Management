package com.service;

import java.util.List;

import com.dto.DeleteEmployee;
import com.repository.DeleteEmployeeRepository;


public class DeleteEmployeeService {
	public int save(DeleteEmployee DeleteEmployee) {
		   DeleteEmployeeRepository drepo = new DeleteEmployeeRepository();
		   return drepo.save(DeleteEmployee);   
	   }
	   public List<DeleteEmployee> getAll() {
		   DeleteEmployeeRepository drepo = new DeleteEmployeeRepository();
		  return drepo.findAll();  
	   }
	public static int delete(String EmailId) {
		  DeleteEmployeeRepository repo = new DeleteEmployeeRepository();
		  return repo.delete(EmailId) ;
	   }
	
	
	
}
