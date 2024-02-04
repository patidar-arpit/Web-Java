package dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;
import utils.HibernateUtils;

public class AddressDaoImpl  implements AddressDao{

	// city country state zipcode
	@Override
	public void assignAddressLink(String city, String country, String state, String zipCode,long id) {
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			   Employee e  = session.get(Employee.class, id);
			   if(e != null) {
				   Address adrr = new Address(city,country,state,zipCode);
				   adrr.setEmp(e);
				   session.save(adrr);	   
				   tx.commit();
			   }
			   else {
				   throw new RuntimeException("Invalid employee id");
			   }
		}
		catch(RuntimeException e) {
			if(tx!=null)
				 tx.rollback();
			throw e;
		}
				
		
	}

	@Override
	public void displayAddress(long id) {
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			  
			String jpql= "select a from Address a  where a.emp.id =:id";
			Address adr = session.createQuery(jpql, Address.class)
					               .setParameter("id", id)
					               .getSingleResult();
			
			System.out.println(adr.getCity()+" "+adr.getState());
			tx.commit();
		}
		catch(NoResultException e) {
			System.out.println("Invalid id");
		}
		catch(RuntimeException e) {
			if(tx!=null)
				 tx.rollback();
			throw e;
		}
		
	}

	@Override
	public void displayNameByAddress(String city) {
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			  
			String jpql= "select a.emp.id from Address a  where a.city=:city";
			
			List<Long> ans = session.createQuery(jpql, Long.class)
					               .setParameter("city", city)
					               .getResultList();
			
			
			for(long i :ans) {
				String jpql1= "select e.lastName from Employee  e where e.id=:i";
				String lastName = session.createQuery(jpql1, String.class)
						                    .setParameter("i", i)
						                    .getSingleResult();
				System.out.println(lastName);
			}
			tx.commit();
		}
		catch(NoResultException e) {
			System.out.println("Invalid id");
		}
		catch(RuntimeException e) {
			if(tx!=null)
				 tx.rollback();
			throw e;
		}
		
		
		
	}

}
