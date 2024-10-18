package com.mapper;

import javax.servlet.http.HttpServletRequest;


import com.dto.GoalDetail;

public class GoalMapper {
	

	public GoalDetail mapToGoalDetail(HttpServletRequest request)
	{
		GoalDetail GoalDetail = new GoalDetail();
		GoalDetail.setEmployeeEmailid(request.getParameter("employeeEmailId"));
		GoalDetail.setGoalDescription(request.getParameter("goalDescription"));
		GoalDetail.setStartDate(request.getParameter("startDate"));
		GoalDetail.setEndDate(request.getParameter("endDate"));
		
		
		
				return GoalDetail;
	}

}
