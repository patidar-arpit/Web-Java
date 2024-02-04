package tester;

import java.util.Scanner;

import dao.BankAccountDao;
import dao.BankAccountDaoImpl;

public class TestBankAccount {

	public static void main(String[] args) {
		   
		 try (Scanner sc =new Scanner(System.in)){
			
			 BankAccountDao account = new BankAccountDaoImpl();
			 
			String ans = account.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble());
			 System.out.println(ans);
			 String ans1  =  account.transFundByFunc(sc.nextInt(),sc.nextInt(),sc.nextDouble());
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
