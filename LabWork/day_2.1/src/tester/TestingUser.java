package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImpl;
import pojos.User;

public class TestingUser {

	public static void main(String[] args) {

      try(Scanner sc = new Scanner(System.in)) {
     	UserDao usd = new UserDaoImpl();
		System.out.println("Enter first_name , last_name ,email , password ,dob");
	
		String ans =usd.addNewVoter(new User(sc.next(),sc.next(),sc.next(),sc.next(),Date.valueOf(sc.next())));
		System.out.println(ans);	
     	System.out.println("Enter the id which you want to be deleted.!");
     	String ans1= usd.deleteUserById(sc.nextInt());
		System.out.println(ans1);
    	  
    	 System.out.println("Enter id of voter:");
    	 if(usd.updateStatusById(sc.nextInt())) {
    		  System.out.println("Updated..!");
    	 }
    	 else {
    		 System.out.println("Not Updated.!");
    	 }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
      
      

	}

}
