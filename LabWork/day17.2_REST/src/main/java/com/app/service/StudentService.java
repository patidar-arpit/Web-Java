package com.app.service;

import java.util.List;

import com.app.dto.StudentDto;
import com.app.entity.Student;

public interface StudentService {
       List<Student> getAllEmployee();

	List<Student> getStudentByCourse(String courseName);

	Student getStudentById(int id);

	StudentDto addStudent(StudentDto student);

	String deleteStudentById(int id);

	Student updateStudent(Student s);

	Student updateCourseNameByid(int id, String courseName);
} 
