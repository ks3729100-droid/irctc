package com.kodewala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.request.EmployeeRequest;
import com.kodewala.response.EmployeeResponse;
import com.kodewala.service.EmployeeService;

@RestController
@RequestMapping("/emp/")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("details")
	public EmployeeResponse showDetails(@RequestBody EmployeeRequest request)
	{
		return service.empDetails(request);
	}
}
