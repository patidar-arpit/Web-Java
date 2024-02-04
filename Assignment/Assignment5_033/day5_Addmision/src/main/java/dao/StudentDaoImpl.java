package dao;
import utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.*;
import utils.*;

public class StudentDaoImpl  implements StudentDao {
    
	private Connection cn ;
	private PreparedStatement pst1,pst2;
	
	public StudentDaoImpl() throws SQLException {  
		 cn = DBUtils.getCn();
		 pst1 = cn.prepareStatement("Select * from student where email=?");
		 pst2 = cn.prepareStatement("insert  into student values(default,?,?,?,?,?)");
	}
	public boolean addStudent(String first_name,String last_name,String email,int score,int course_id) throws SQLException {
		 
		pst2.setString(1, first_name);
		pst2.setString(2,last_name);
		pst2.setString(3, email);
		pst2.setInt(4, score);
		pst2.setInt(5,course_id);
		
		int rowCount = pst2.executeUpdate();
		if(rowCount==1) {
			return true;
		}
		return false;
		
	}
	public Student getStudentByemail(String email) throws SQLException {
		
		 pst1.setString(1, email);
		 ResultSet rst = pst1.executeQuery();
		 if(rst.next()) {
			 return new Student(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getInt(6));
		 }
		 return null;
	}
	

}
