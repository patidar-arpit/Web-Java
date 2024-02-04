package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmployeeType;

public class BulkDelete {

	public static void main(String[] args) {
		try(	Scanner sc= new Scanner(System.in);
			SessionFactory sf = getSessionFactory()){
			
			EmployeeDao edao = new EmployeeDaoImpl();    
			System.out.println("Enter tyoe of employee which you want to delete:");
			edao.deleteByType(sc.next());
			
		} //JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			 e.printStackTrace();
		}

	}

}
