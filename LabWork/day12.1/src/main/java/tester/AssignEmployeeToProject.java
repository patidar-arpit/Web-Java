package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDao;
import dao.ProjectDaoImpl;

public class AssignEmployeeToProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDao  pdao =  new ProjectDaoImpl();
			System.out.println("Enter the employee id and poject id in which you want to assign him");
			pdao.assignEmployee(sc.nextLong(),sc.nextLong());
		} 
	     catch (Exception e) {
			  e.printStackTrace();
		}


	}

}
