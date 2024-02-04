package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.User;


@WebServlet("/admin")
public class AdminPage extends HttpServlet{
	//doGet
	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		System.out.println("in admin page ");
		//1. set resp cont type
		rs.setContentType("text/html");
		//2. get PW : to send resp from servlet ---> web clnt
		try(PrintWriter pw=rs.getWriter()) {
			//generate dyn cont (add dyn contents to buffer of PW
			HttpSession session = rq.getSession();
			User user = (User) session.getAttribute("client_details");
			CandidateDaoImpl cdo = (CandidateDaoImpl) session.getAttribute("candidate_dao");
			pw.print("<h4>Admin Page .!!</h4>");
			pw.print("<h5>Welcome "+user.getFirstName()+" as a Admin.!! </h5>");
			
			pw.print("<h5> Top Two  Candidates having maximum Votes..! ");
			
			List<Candidate> candidates = cdo.maxVoteCandidate();
			
			for(Candidate c : candidates) {
				pw.print("<h5> Name:"+c.getCandidateName()+",     Party:"+c.getParty()+",      Votes:"+c.getVotes()+"</h5>");
			}
			
			pw.print("<h5><a href = ' addCandidate.html'>Add a candidate</a></h5>");
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException("Error in the doGet of adminPage",e);
		}
	}

}
