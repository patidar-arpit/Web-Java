package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeService {
    
	@Autowired
	private EmployeeDao empDao;
	public Optional<Employee> addEmployee(Employee emp) {
		
           empDao.save(emp);
           return empDao.findById(emp.getId());
	        
	}
	public List<Employee> displayAllEmployees() {
		
		return empDao.findAll();
		
		
	}
	public List<Employee> getCompanyWiseEmpDetail(String companyName) {
		
		
		return  empDao.findByCompanyName(companyName);
	}
	public Employee getEmployeeByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return empDao.findByFirstName(firstName).orElseThrow();
	}
	
}
