package dao;
import utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.*;
import utils.*;

public class StudentDaoImpl  implements StudentDao {
    
	private Connection cn ;
	private PreparedStatement pst1;
	
	public StudentDaoImpl() throws SQLException {  
		 cn = DBUtils.getCn();
		 pst1 = cn.prepareStatement("Select * from course where short_form=?");
	}
	public Student addStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
