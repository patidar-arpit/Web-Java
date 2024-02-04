package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	//dep : 
	@Autowired //byType OR @PersistenceContext : JPA anno
	private EntityManager mgr;//super i/f of Hibernate Session

	@Override
	public List<Employee> getAllEmps() {
		String jpql="select e from Employee e";// e join fetch e.myDept";
		return mgr
				.createQuery(jpql, Employee.class)
				.getResultList();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		 mgr.persist(emp);
		 
		 return emp;
	}

	@Override
	public List<Employee> empDetails() {
		
		String  jpql = "Select e from Employee e";
		return mgr.createQuery(jpql, Employee.class).getResultList();
	}

	@Override
	public List<Employee> displayEmployeeByCompany(String companyName) {
		
		String jpql = "Select e from Employee e where e.companyName=:companyName";
		
		return mgr.createQuery(jpql,Employee.class).setParameter("companyName", companyName).getResultList();
	}

}
