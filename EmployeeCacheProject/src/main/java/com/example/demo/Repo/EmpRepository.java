package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Employeee;

public interface EmpRepository extends JpaRepository<Employeee, Integer> {

}
