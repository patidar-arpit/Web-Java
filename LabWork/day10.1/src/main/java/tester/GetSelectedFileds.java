package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmployeeType;

public class GetSelectedFileds {

	public static void main(String[] args) {
		try(	Scanner sc= new Scanner(System.in);
			SessionFactory sf = getSessionFactory()){
		
			EmployeeDao edao = new EmployeeDaoImpl();
            
			System.out.println("Enter date &  Salary:");
			edao.getSelectedField(sc.next(),sc.nextDouble()).forEach(e->System.out.println(e));
			
		} //JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			 e.printStackTrace();
		}

	}

}
