package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.Candidate;
import pojos.User;


@WebServlet("/logout")
public class LogoutPage extends HttpServlet{
	//doGet
	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		try (PrintWriter pw = rs.getWriter()){
			     rs.setContentType("text/html");
			     pw.print("Logout Page..!");
			     HttpSession hs = rq.getSession();
			    User user = (User) hs.getAttribute("client_details");
			    CandidateDaoImpl cdo = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
			    UserDaoImpl usd  = (UserDaoImpl) hs.getAttribute("user_dao"); 
			   
			   if(user != null) {
				   pw.print("<h3> Thankyou ,"+user.getFirstName()+" for Voting"+"</h3>");
				     if(cdo.getVotingStatus(user.getUserId())==false) {
				    	 usd.updateStatusById(user.getUserId());
				    	 String  str = rq.getParameter("candidate_id");
					     int id  = Integer.valueOf(str);
					     cdo.updateVoteById(id);
					     
				     }
				     else{
				    	 pw.print("<h3> you already have voted..!</h3>");
				     }
				          
			   }
			   else {
				    pw.print("<h3> Please Login First..!</h3>");
			   }
			     
			 
		} catch (Exception e) {
			  e.printStackTrace();
			  throw new ServletException("in the doget of the logout page",e);
		}
	}

}
