package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.ProjectDao;
import dao.ProjectDaoImpl;
import pojos.Address;
import pojos.Employee;
import utils.HibernateUtils;

public class AddProject {

	public static void main(String[] args) {
		   
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			ProjectDao  pdao =  new ProjectDaoImpl();
			System.out.println("Enter the project deatils(title,endDate,startDate,)");
			pdao.addProject(sc.next(), sc.next(), sc.next());
		} 
	     catch (Exception e) {
			  e.printStackTrace();
		}

	}
		
		
		
	}

