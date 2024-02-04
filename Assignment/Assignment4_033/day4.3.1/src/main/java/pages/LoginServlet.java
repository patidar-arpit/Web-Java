package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.User;
import static utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;

	public void init() throws ServletException {
		System.out.println("in init of " + getClass());
		try {
			//open cn : singleton
			openConnection();
			// create user dao n candidate dao instance
			userDao = new UserDaoImpl();
			candidateDao=new CandidateDaoImpl();
			
		} catch (Exception e) {
			// centralized err handling
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			userDao.cleanUp();
			candidateDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			// inform WC about the err : OPTIONAL !
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	       response.setContentType("text/html");
	       try(PrintWriter pw = response.getWriter()) {
	    	   
	    	    String email = request.getParameter("em");
				String pwd = request.getParameter("pass");
				// 4. invoke user dao's method for auth
				User user = userDao.authenticateUser(email, pwd);
				if (user == null) // => invalid login
					pw.print("<h4> Invalid Login Please <a href='login.html'>Retry</a></h4>");
				
				else {
					      
					      HttpSession hs = request.getSession();
					      hs.setAttribute("client_details", user);
					      hs.setAttribute("user_dao",userDao );
					      hs.setAttribute("candidate_dao", candidateDao);
					      
					      if(user.getRole().equals("admin")) {
					    	   response.sendRedirect("admin");
					      }
					      else {
					    	  if(user.isVotingStatus()) {
					    		  response.sendRedirect("logout");
					    	  }
					    	  else {
					    		  response.sendRedirect("candidate_list");
					    	  }
					      }
				}
	    	   
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("Exception in doPost in LoginServlet ",e);
		} 
	       
	       
			
	}
		 
}

