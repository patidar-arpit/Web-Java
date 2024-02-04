package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.*;

import pojos.Employee;
import pojos.EmployeeType;
import utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee addEmpDetails(Employee newEmp) {

		// 1.Creating or opening the session
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2 Begin the transaction
		Transaction tx = session.beginTransaction();
		Employee emp;
		try {
			session.save(newEmp); // it not inserted into the db it is int he Persistent state and get inserted on
									// the time of the tx.commit()
			emp = session.get(Employee.class, newEmp.getEmpId()); // this first will search on L1 cache and it will
																	// found so it not sesrch in the Db
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.commit();
			throw e;
		}

		return emp;
	}

	@Override
	public List<Employee> getAllEmp() {

		// 1.Creating or opening the session
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2 Begin the transaction
		Transaction tx = session.beginTransaction();
		List<Employee> ans = null;
		try {

			String jpql = "select e from Employee e";
			ans = session.createQuery(jpql, Employee.class).getResultList();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.commit();
			throw e;
		}

		return ans;
	}

	@Override
	public Employee getEmpDetailById(long id) {

		// 1.Creating or opening the session
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2 Begin the transaction
		Transaction tx = session.beginTransaction();
		Employee emp;
		try {

			emp = session.get(Employee.class, id);

		} catch (RuntimeException e) {
			if (tx != null)
				tx.commit();
			throw e;
		}

		return emp;

	}

	@Override
	public List<String> getFirstNameByType(String next) {
		
		// 1.Creating or opening the session
				Session session = HibernateUtils.getSessionFactory().getCurrentSession();
				// 2 Begin the transaction
				Transaction tx = session.beginTransaction();
				List<String> ans;
				try {
                     
					String jpql  ="select e.firstName from Employee e where e.empType = : type";
					 ans = session.createQuery(jpql, String.class)
					.setParameter("type", EmployeeType.valueOf(next))
					.getResultList();
					 

				} catch (RuntimeException e) {
					if (tx != null)
						tx.commit();
					throw e;
				}

				return ans;
		   
	}

	@Override
	public List<Employee> getSelectedField(String joinDate, double sal) {
		// 1.Creating or opening the session
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2 Begin the transaction
		Transaction tx = session.beginTransaction();
		List<Employee> ans;
		try {
            
			LocalDate  date1 = LocalDate.parse(joinDate);
			String jpql  ="select e from Employee e where e.joinDate=:joinDate and e.salary >:sal";
			 ans = session.createQuery(jpql, Employee.class)
			.setParameter("joinDate",LocalDate.parse(joinDate))
			.setParameter("sal",sal)
			.getResultList();
			 

		} catch (RuntimeException e) {
			if (tx != null)
				tx.commit();
			throw e;
		}

		return ans;

	}

	@Override
	public List<Employee> testConstExpression(String type) {
		
		// 1.Creating or opening the session
				Session session = HibernateUtils.getSessionFactory().getCurrentSession();
				// 2 Begin the transaction
				Transaction tx = session.beginTransaction();
				List<Employee> ans;
				try {
		            
					
					String jpql  ="select  new Employee(e.firstName,e.lastName,e.salary)  from Employee e where e.empType=: type";
					 ans = session.createQuery(jpql, Employee.class)
					.setParameter("type",EmployeeType.valueOf(type))
					.getResultList();
					 

				} catch (RuntimeException e) {
					if (tx != null)
						tx.commit();
					throw e;
				}

				return ans;
		
	}

}