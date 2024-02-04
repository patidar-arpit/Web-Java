package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {

	public String addNewVoter(User newUser) throws SQLException;

	public String deleteUserById(int id) throws SQLException;
	
	public boolean updateStatusById(int id) throws SQLException;
	

}
