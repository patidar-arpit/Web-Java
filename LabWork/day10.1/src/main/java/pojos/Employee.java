package pojos;
import java.time.LocalDate;

import javax.persistence.*;


@Entity 
@Table(name ="emps")
public class Employee  extends BaseEntity {
       

	@Column(name ="first_name",length=20)
	 private String firstName;
	 
	 @Column(name ="last_name",length=20)
	 private String lastName;
	  
	 @Column(unique=true)
	 private String email;
	 
	 @Column(nullable = false)
	 private String password;
	 
	 @Column(name="join_date")
	 private LocalDate joinDate;
	 
	 @Enumerated(EnumType.STRING)
	 private EmployeeType empType;
	 
	 private double salary;
	 
	 public Employee() {
		 
	 }
	 
	 public Employee(String firstName,String lastName,double sal) {
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.salary = sal;
	 }

	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			EmployeeType empType, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.empType = empType;
		this.salary = salary;
	}
	


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public EmployeeType getEmpType() {
		return empType;
	}

	public void setEmpType(EmployeeType empType) {
		this.empType = empType;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	 @Override
		public String toString() {
			return "Employee [empId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", password=" + password + ", joinDate=" + joinDate + ", empType=" + empType + ", salary=" + salary
					+ "]";
		}
	
	
	 
	 
	 
	 
}
