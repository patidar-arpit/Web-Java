package dao;

import java.time.LocalDate;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;
import pojos.Project;
import utils.HibernateUtils;

public class ProjectDaoImpl  implements ProjectDao{

	@Override
	public String addProject(String title,String startDate, String endDate) {
		 
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			  Project pro = new Project(title,LocalDate.parse(startDate),LocalDate.parse(endDate));
			  session.save(pro);
			  tx.commit();
		}
		catch(RuntimeException e) {
			if(tx!=null)
				 tx.rollback();
			throw e;
		}	
     return "Project Added";
   }

	@Override
	public void assignEmployee(long empId, long projectId) {
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			  
			Project p = session.get(Project.class, projectId);
			Employee e =session.get(Employee.class, empId);
			p.addEmployee(e);
			e.addProject(p);
		    tx.commit();
		}
		catch(RuntimeException e) {
			if(tx!=null)
				 tx.rollback();
			throw e;
		}	
		
	}
	
}
