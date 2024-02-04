package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student extends BaseEntity{
	
	private int rollNo;
	private String city;
	private String courseName;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	
	

}
