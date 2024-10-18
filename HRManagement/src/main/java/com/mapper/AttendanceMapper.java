package com.mapper;

import javax.servlet.http.HttpServletRequest;

import com.dto.AttendanceDetail;


public class AttendanceMapper {


	public AttendanceDetail mapToAttendanceDetail(HttpServletRequest request)
	{
		AttendanceDetail AttendanceDetail = new AttendanceDetail();
		AttendanceDetail.setEmployeeName(request.getParameter("EmployeeName"));
		AttendanceDetail.setEmployeeEmailid(request.getParameter("Emailid"));
		AttendanceDetail.setDate(request.getParameter("Date"));
		AttendanceDetail.setTime(request.getParameter("Time"));
		
		
		
				return AttendanceDetail;
	}

}
