package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import pojos.User;

@WebServlet(value="/signup",loadOnStartup = 60)
public class SignupServlet extends HttpServlet {
       UserDaoImpl usd;
     
     @Override
	public void init() throws ServletException {
		  try {
			usd= new UserDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Error in init of signup servlet",e);
		}
		  
	}
 
	@Override
	public void destroy() {
		 try {
			usd.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
	    try{
	    	 
	    	  String first_name = request.getParameter("fname");
	    	  String last_name = request.getParameter("lname");
	    	  String email = request.getParameter("em");
	    	  String password = request.getParameter("pass");
	    	  LocalDate date = LocalDate.parse(request.getParameter("dob")); 
	    	   
	    	   if(usd.validateVoterByDate(date)) {
	    		    if(usd.validateVoterByEmail(email)) {
	    		          User newVoter  = new User (first_name,last_name,email,password,Date.valueOf(date));
                          usd.registerNewVoter(newVoter);
                          pw.print("<h3> Registration Successfull.!!<h3>");
	    		    }
	    		    else {
	    		    	pw.print("<h3> Registration Failed..! Voter  Exists<h3>");
	    		    }
	    		    	   
	    	   }
	    	   else {
	    		   pw.print("<h3> Registration Failed..! Invalid Age<h3>");
	    	   }
	    	        	
	    } catch (SQLException e) {
      		e.printStackTrace();
		}		
	}

}
