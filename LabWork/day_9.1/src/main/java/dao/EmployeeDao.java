package dao;

import java.util.List;

import pojos.Employee;

public interface EmployeeDao {
     
	Employee addEmpDetails(Employee emp);

	List<Employee> getAllEmp();

	Employee getEmpDetailById(long id);

	List<String> getFirstNameByType(String next);

	List<Employee> getSelectedField(String next, double nextDouble);

	List<Employee> testConstExpression(String next);
}
