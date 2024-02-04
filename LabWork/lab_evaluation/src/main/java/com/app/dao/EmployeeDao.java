package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.pojos.Employee;


public interface EmployeeDao extends JpaRepository<Employee,Integer>,CrudRepository<Employee, Integer> {
    
	Optional<Employee> findById(Integer id);
	List<Employee> findAll();
	
	Optional<Employee> findByFirstName(String firstName);
	List<Employee> findByCompanyName(String companyName);
	
	 
}
