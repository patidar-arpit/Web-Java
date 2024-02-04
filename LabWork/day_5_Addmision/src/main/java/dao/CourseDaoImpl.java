package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Course;
import utils.DBUtils;

public class CourseDaoImpl  implements CourseDao{
	private Connection cn ;
	private PreparedStatement pst1,pst2;
	public  CourseDaoImpl() throws SQLException {
		
		  cn = DBUtils.getCn();
		 pst1 = cn.prepareStatement("Select * from course where short_form=?");
		 pst2 = cn.prepareStatement("select * from course where course_id = ?");
		
	}

	@Override
	public Course getCourseDetail(String course) throws SQLException {
		 
		 pst1.setString(1, course);
		 ResultSet rst = pst1.executeQuery();
		 if(rst.next()) {
			 return new Course(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
		 }
		 return null;
	} 
	public Course getCourseDetailById(int id) throws SQLException {
		
		pst2.setInt(1, id);
		 ResultSet rst = pst2.executeQuery();
		 if(rst.next()) {
			 return new Course(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
		 }
		 return null;
			
		}
	}
