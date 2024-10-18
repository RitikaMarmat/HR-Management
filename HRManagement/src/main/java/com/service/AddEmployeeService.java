package com.service;

import java.util.List;

import com.dto.AddEmployee;
import com.repository.AddEmployeeRepository;



public class AddEmployeeService {
	public int save(AddEmployee AddEmployee) {
		   AddEmployeeRepository repo = new AddEmployeeRepository();
		   return repo.save(AddEmployee);   
	   }
	   public List<AddEmployee> getAll() {
		   AddEmployeeRepository  repo = new AddEmployeeRepository();
		  return repo.findAll();  
	   }
	   public int delete(String Emailid) {
		   AddEmployeeRepository repo = new AddEmployeeRepository();
		  return repo.delete(Emailid) ;
	   }
}
