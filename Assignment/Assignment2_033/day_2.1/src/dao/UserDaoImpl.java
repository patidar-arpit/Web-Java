package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.User;
import utils.DBUtils;

public class UserDaoImpl  implements UserDao{
	
	private Connection cn;
	private PreparedStatement pst1;
	
	public UserDaoImpl() throws SQLException {
		cn = DBUtils.openConnection();
		//// first_name | last_name | email | password | dob
		System.out.println("Dao Created..!");
	}

	@Override
	public String addNewVoter(User newUser) throws SQLException {
		
		pst1 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
        pst1.setString(1, newUser.getFirstName());
        pst1.setString(2,newUser.getLastName() );
        pst1.setString(3, newUser.getEmail());
        pst1.setString(4, newUser.getPassword());
        pst1.setDate(5, newUser.getDob());
        pst1.setBoolean(6, false);
        pst1.setString(7,"voter");
        
        int rowCount = pst1.executeUpdate();
        
        if(rowCount==0) {
        	return "Voter not added in the list";
        }
		return "Voter Successfully added";
        
	}

	@Override
	public String deleteUserById(int  id) throws SQLException {
		pst1 = cn.prepareStatement("delete from users where id =?");
		pst1.setInt(1, id);
		
		int rowCount = pst1.executeUpdate();
		
		if(rowCount==0)
			  return "User Not Deleted";
		
		return  "User Deleted..!";
				
		
	}

	@Override
	public boolean updateStatusById(int id) throws SQLException {
		
	    pst1 = cn.prepareStatement("update users set status= ? where id = ?");
	    pst1.setInt(1, 1);
	    pst1.setInt(2, id);
	    
	    int rowCount =pst1.executeUpdate();
	    if(rowCount==0)
	    	 return false;
	    	
		return true;
	}
	
	
	
	

}
