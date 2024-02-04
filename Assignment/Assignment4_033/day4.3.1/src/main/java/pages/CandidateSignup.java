package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidateDaoImpl;
import pojos.Candidate;

/**
 * Servlet implementation class CandidateSignup
 */
@WebServlet("/candidate_signup")
public class CandidateSignup extends HttpServlet {
       
	CandidateDaoImpl dao ;
    public void init() {
    	try {
			dao = new CandidateDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String name  = request.getParameter("name");
		  String party = request.getParameter("party");
		  
		  try(PrintWriter pw = response.getWriter()){
			   
			   pw.print("<h3>In Candidate Signup</h3>");
			   dao.registerCandidate(name, party);
			   pw.print("<h3> Candidate Added Successfully</h3>");
			  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		}
		  
		 
	}

}
