package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.*;
import utils.HibernateUtils;

public class AssignAddress {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = HibernateUtils.getFactory() ){
			
			   AddressDao adao = new AddressDaoImpl();
			   System.out.println("Enter the city country state zipcode of employee and enter id");
			   adao.assignAddressLink(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextLong());
			
		}

	}

}
