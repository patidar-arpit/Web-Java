package bean;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import dao.UserDaoImpl;
import pojos.User;

public class Userbean {
	
	private String email;
	private String pass;
	private String fname;
	private String lname;
	private String  dob;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	private UserDaoImpl userDao;
	
	public Userbean() throws SQLException {
		userDao = new UserDaoImpl();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	
	public String  authenticateUser() throws SQLException {
		   
		User user =  userDao.authenticateUser(email, pass);
		if(user!=null) {
			if(user.getRole().equals("admin"))
				 return "logout";
			else {
				if(user.isVotingStatus())
					 return "logout";
			}
		}
		return "login";
	}
	
	public String voterRegistration() throws SQLException {
		
		if(Period.between(LocalDate.parse(dob), LocalDate.now()).getYears()>18) {
			 User user = new User(fname,lname,email,pass,Date.valueOf(dob));   
			  return userDao.registerNewVoter(user); 
		}
		return "Invalid Age";
	}
	

}
