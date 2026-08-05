package com.kodewala.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.EmployeeEntity;
import com.kodewala.kafka.service.KafkaService;
import com.kodewala.repository.EmployeeRepository;
import com.kodewala.request.EmployeeRequest;
import com.kodewala.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	KafkaService service;
	
	public EmployeeResponse empDetails(EmployeeRequest request)
	{
		EmployeeEntity entity = new EmployeeEntity();
		
		entity.setEmployeeName(request.getEmployeeName());
		entity.setDepartment(request.getDepartment());
		entity.setDesignation(request.getDesignation());
		entity.setEmail(request.getEmail());
		entity.setSalary(request.getSalary());
		
		EmployeeEntity employeeSaved = repository.save(entity);
		
		EmployeeResponse response = new EmployeeResponse();
		
		response.setEmployeeId(employeeSaved.getEmployeeId());
		response.setEmployeeName(employeeSaved.getEmployeeName());
		response.setDepartment(employeeSaved.getDepartment());
		response.setDesignation(employeeSaved.getDesignation());
		response.setEmail(employeeSaved.getEmail());
		response.setSalary(employeeSaved.getSalary());
		
		//send message to kafka
		
		for (int i = 0; i < 10; i++) {
			
			String message = "This is test message and eMail is: " + response.getEmail();
			service.publishMessage("employee-biodata", message);
		}
		
		return response;
	}
	
}
