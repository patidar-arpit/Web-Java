package pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Department extends BaseEntity{
	
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String location;
	
	@OneToMany(mappedBy = "myDept")
	private List<Employee> employees;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void addEmployee(Employee e) {
		employees.add(e);
		e.setMyDept(this);
		
	}

}
