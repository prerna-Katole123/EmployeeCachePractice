package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employeee;
import com.example.demo.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("employee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employeee employeee)
	{
		employeeService.saveEmployee(employeee);
		return new ResponseEntity<String>("employee saved", HttpStatus.CREATED);
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<Employeee> getEmployee(@PathVariable int id)
	{
		Employeee employeee=employeeService.getEmployee(id);
		return new ResponseEntity<Employeee>(employeee,HttpStatus.OK);
	}

}
