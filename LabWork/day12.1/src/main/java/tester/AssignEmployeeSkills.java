package tester;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class AssignEmployeeSkills {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDao edao = new EmployeeDaoImpl();
			System.out.println("Enter the id of employee and How many skills?");
			long id  = sc.nextInt();
			int noOfSkills = sc.nextInt();
			List<String> skills = new ArrayList<String>();
			int t = 0;
			while(t<noOfSkills) {
				skills.add(sc.next());
				t++;
			}
			edao.assignSkillsOfEmployee(id,skills);
		} 
	     catch (Exception e) {
			  e.printStackTrace();
		}

	}

}
