package com.app.pojos;


import java.time.LocalDate;
import javax.persistence.*;

@Entity 
@Table(name = "emps")
public class Employee extends BaseEntity{
	
	@Column(name="first_name",length = 30)
	private String firstName;
	
	@Column(name="last_name",length = 30)
	private String lastName;
	
	@Column(length = 30)
	private String city;
	

	@Column(name = "company_name",length = 30)
	private String companyName;
	


	public Employee() {
		System.out.println("in def ctor of emp");
	}
	
	public Employee(String fn, String ln, String city2, String company) {
		this.firstName = fn ;
		this.lastName =ln;
		this.city = city2;
		this.companyName = company;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	@Override
	public String toString() {
		return "Employee [Id = " + getId()  +"   firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", companyName="
				+ companyName + "]";
	}

}