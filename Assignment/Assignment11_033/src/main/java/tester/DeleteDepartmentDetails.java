package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;

public class DeleteDepartmentDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			DepartmentDao deptDao = new DepartmentDaoImpl();
			System.out.println(
					"Enter dept id to be deleted.!");
				 deptDao.deleteDepartment(sc.nextLong());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
