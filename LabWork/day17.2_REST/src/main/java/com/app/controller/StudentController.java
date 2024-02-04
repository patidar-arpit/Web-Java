package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponseStudent;
import com.app.dto.StudentDto;
import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getAllEmployee(){
		
		return studentService.getAllEmployee();
	}
	
	@GetMapping("/course/{courseName}")
	public List<Student> getStudentBySpecificCourse(@PathVariable String courseName ){
		
		return studentService.getStudentByCourse(courseName);
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		
		return studentService.getStudentById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addStudent(@RequestBody  @Valid  StudentDto studentDTO) {
		
		try {
			 int a =10/0;
			 return new ResponseEntity<StudentDto>(studentService.addStudent(studentDTO), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponseStudent(e.getMessage()));
		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudentById(@PathVariable int id) {
		
		return studentService.deleteStudentById(id);
	}
	@PutMapping()
	public  Student updateStudent(@RequestBody Student s) {
		
		return studentService.updateStudent(s);
	}
	
	@PutMapping("/{id}/{courseName}")
	public Student updateCourseNameById(@PathVariable int id, @PathVariable String courseName) {
		
		return studentService.updateCourseNameByid(id,courseName);
	}
	   
}
