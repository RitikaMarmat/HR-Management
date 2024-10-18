package com.service;

import java.util.List;


import com.dto.LeaveDetail;

import com.repository.LeaveRepository;

public class LeaveService {
	
		public int save(LeaveDetail LeaveDetail) {
			 LeaveRepository pass = new LeaveRepository();
			   return pass.save(LeaveDetail);   
		   }
		   public List<LeaveDetail> getAll() {
			   LeaveRepository pass = new LeaveRepository();
			  return pass.findAll();  
		   }
	}

