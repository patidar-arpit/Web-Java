package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface StudentService {
       List<Student> getAllEmployee();

	List<Student> getStudentByCourse(String courseName);

	Student getStudentById(int id);

	Student addStudent(Student student);

	String deleteStudentById(int id);

	Student updateStudent(Student s);

	Student updateCourseNameByid(int id, String courseName);
} 
