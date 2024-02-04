package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entity.Student;


@DataJpaTest  
@AutoConfigureTestDatabase(replace = Replace.NONE) // dont create a dummy database for the testing
@Rollback(false)   // make changes in db  do not rollback default value is true


public class TestStudentDao {
	
	@Autowired
	private StudentDao studentDao; // dependency 
	
	@Test // to specify a method as the test case
	void testAddStudent() {
		List<Student> list =List.of(new Student(101,"Indore", "PG-DAC","Arpit","Patidar",LocalDate.parse("2020-10-20")),
				                 new Student(102,"Pune", "PG-DBDA","Aniket","Ghage",LocalDate.parse("2022-11-19")),
				                 new Student(102,"Nagpur", "PG-DBDA","Jayesh","Murodiya",LocalDate.parse("2023-11-19")));
	
	                          
	   
	    List<Student> savedStudent = studentDao.saveAll(list);
	    assertEquals(3, savedStudent.size());  // it will telling that if the student are adddes the list size should be 3
	                                            // and we are also expecting the list size as 3 so on left top the sucess 
	                                           // green message comes and shows Run 1/1 pases
	                                          // and if 
	
	}
	
}
