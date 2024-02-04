package dao;

import java.sql.SQLException;

import pojos.Course;

public interface CourseDao {
	
	public Course getCourseDetail(String course) throws SQLException;
}
