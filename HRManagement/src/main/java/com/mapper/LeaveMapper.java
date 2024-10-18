package com.mapper;

import javax.servlet.http.HttpServletRequest;


import com.dto.LeaveDetail;

public class LeaveMapper {
	

	public LeaveDetail mapToLeaveDetail(HttpServletRequest request)
	{
		LeaveDetail LeaveDetail = new LeaveDetail();
		LeaveDetail.setEmailId(request.getParameter("employeeEmailId"));
		LeaveDetail.setLeaveType(request.getParameter("leaveType"));
		LeaveDetail.setStartDate(request.getParameter("startDate"));
		LeaveDetail.setEndDate(request.getParameter("endDate"));
		
		
		
				return LeaveDetail;
	}
}
