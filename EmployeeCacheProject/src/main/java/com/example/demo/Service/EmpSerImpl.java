package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Cache.EmpCache;
import com.example.demo.Entity.Employeee;
import com.example.demo.Repo.EmpRepository;

@Service
public class EmpSerImpl implements EmployeeService {

	@Autowired
	EmpRepository empRepository;

	private EmpCache empCache;

	@Autowired
	public void setEmpCache(EmpCache empCache) {
		this.empCache = empCache;
	}

	@Override
	public void saveEmployee(Employeee employeee) {
		empRepository.save(employeee);

	}

	@Override
	public Employeee getEmployee(int id) {
		System.out.println("checking data in cache");
		if (empCache.checkDataInCache(id)) {
			System.out.println("getting data from cache");
			return empCache.getDataFromCache(id);
		}
		System.out.println("getting data from db");
		Employeee employeee = empRepository.findById(id).get();
		System.out.println("storing data in cache");
		empCache.storedDataInCache(employeee);
		return employeee;
	}

}
