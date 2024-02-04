package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	//dep
	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> listEmps() {
		return null;
	}

	@Override
	public Employee addEmployee(Employee emp) {

		return empDao.addEmployee(emp);
	}

	@Override
	public List<Employee> empDetails() {
		return empDao.empDetails();
	}

	@Override
	public List<Employee> displayEmployeeByCompany(String companyName) {
		return empDao.displayEmployeeByCompany(companyName);
	}

}
