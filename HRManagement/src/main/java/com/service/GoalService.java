package com.service;

import java.util.List;


import com.dto.GoalDetail;

import com.repository.GoalRepository;

public class GoalService {
	public int save(GoalDetail GoalDetail) {
		   GoalRepository pass = new GoalRepository();
		   return pass.save(GoalDetail);   
	   }
	   public List<GoalDetail> getAll() {
		   GoalRepository pass = new GoalRepository();
		  return pass.findAll();  
	   }
}
