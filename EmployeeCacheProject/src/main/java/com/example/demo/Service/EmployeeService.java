package com.example.demo.Service;

import com.example.demo.Entity.Employeee;

public interface EmployeeService {

	public void saveEmployee(Employeee employeee);
	
	public Employeee getEmployee(int id);
}
