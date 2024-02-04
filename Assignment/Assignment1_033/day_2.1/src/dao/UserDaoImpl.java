package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<User> getUserByRole(String role) throws SQLException {
		// TODO Auto-generated method stub
		pst = cn.prepareStatement("Select * from users where role = ?");
		pst.setString(1, role);
		List<User> ans = new ArrayList<User>();
		
		ResultSet rst = pst.executeQuery();
		
		while(rst.next()) {
			ans.add(new User(rst.getString(2)));
		}
		
		return ans;
	}

	public User validateUser(String email, String pass) throws SQLException {
	
		pst = cn.prepareStatement("Select * from users where email = ? and password =?");
		pst.setString(1, email); // this method set the email at first ? (wildcard)
		pst.setString(2, pass); //  -----------------------------Second ? (wildcard)
		
		ResultSet rst = pst.executeQuery();
		
	    if(rst.next()) {
	    	return new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDate(6),rst.getBoolean(7),rst.getString(8));
	     // new User(1,"Arpit","pATIDAR",.........);
	    }
	    
		return null;
	}

	
	

}
