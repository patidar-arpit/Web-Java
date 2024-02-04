package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class StudentDto {
    
	private int id;
	private int rollNo;
	
	@Size(min = 3, max = 15)
	private String city;
	private String courseName;
	
	@NotBlank(message ="FirstName is required")
	private String firstName;
	private String lastName;
	
	@Past
	private LocalDate dob;
	
	
}
