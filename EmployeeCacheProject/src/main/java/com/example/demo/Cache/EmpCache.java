package com.example.demo.Cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.Employeee;
import com.example.demo.Repo.EmpRepository;

import jakarta.annotation.PostConstruct;

@Component
public class EmpCache {

	private EmpRepository empRepository;

	public EmpCache(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	Map<Integer, Employeee> map = new ConcurrentHashMap<>();

	public void storedDataInCache(Employeee employeee) {
		map.put(employeee.getId(), employeee);
	}

	public boolean checkDataInCache(int id) {
		return map.containsKey(id);
	}

	public Employeee getDataFromCache(int id) {
		return map.get(id);
	}

	public void clearCache() {
		System.out.println("clearing cache");
		map.clear();
	}

	@PostConstruct
	public void fetchAllDataFromDb() {
		System.out.println("fetching all data from db");
		List<Employeee> l = empRepository.findAll();
		for (Employeee e : l) {
			map.put(e.getId(), e);
		}
	}

}
