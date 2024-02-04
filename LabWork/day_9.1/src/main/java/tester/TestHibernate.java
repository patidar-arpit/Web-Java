package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmployeeType;

public class TestHibernate {

	public static void main(String[] args) {
		try {
			Scanner sc= new Scanner(System.in);
			SessionFactory sf = getSessionFactory();
			EmployeeDao edao = new EmployeeDaoImpl();
//
			System.out.println("Enter Employee Deatails:");
			System.out.println("Enter firstName lastName, email, password,joinDate, empType, salary");
			System.out.println(edao.addEmpDetails(new Employee(sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),EmployeeType.valueOf(sc.next()),sc.nextDouble())));
			
			
			sc.close();
			sf.close();
		} //JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
