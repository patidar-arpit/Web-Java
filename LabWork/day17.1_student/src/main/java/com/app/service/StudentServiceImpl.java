package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.entity.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
      
	@Autowired
	private StudentDao  studentDao;
	
	@Override
	public List<Student> getAllEmployee() {
		
		return studentDao.findAll();
	}

	@Override
	public List<Student> getStudentByCourse(String courseName) {
		// TODO Auto-generated method stub
		return studentDao.findByCourseName(courseName);
	}

	@Override
	public Student getStudentById(int id) {
		return studentDao.findById(id).orElseThrow();
	}

	@Override
	public Student addStudent(Student student) {
		
		return studentDao.save(student);
	}

	@Override
	public String deleteStudentById(int id) {
		
	    if(studentDao.existsById(id)) {
	    	studentDao.deleteById(id);
	    	return "Student Deleted";
	    }
	    return "Invalid id";
	}

	@Override
	public Student updateStudent(Student s) {
		
		return studentDao.save(s);
	}

	@Override
	public Student updateCourseNameByid(int id, String courseName) {
		
		  Student s = studentDao.findById(2).orElseThrow();
		  s.setCourseName(courseName);
		  return studentDao.save(s);
	}

}
