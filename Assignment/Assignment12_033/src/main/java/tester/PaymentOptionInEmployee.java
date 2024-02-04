package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class PaymentOptionInEmployee {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDao edao = new EmployeeDaoImpl();
			System.out.println("Enter the id of employee and PaymentDetail(Payment_type,cvv,expiryDate,)");
			edao.paymentDetail(sc.nextLong(),sc.next(),sc.next(),sc.next());
		} 
	     catch (Exception e) {
			  e.printStackTrace();
		}
	}

}
