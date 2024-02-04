package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

@WebServlet(value = "/authenticate", loadOnStartup = 69)
public class LoginServlet extends HttpServlet {
	UserDaoImpl usd ;
	public void init() throws ServletException {
		System.out.println("In the init of login servlet");

		try {
			usd = new UserDaoImpl();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("Error in init of login servelet", e);
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub
		try {
			usd.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			    String email = request.getParameter("em");
			    String pass  = request.getParameter("pass");
			    
			    User user = usd.authenticateUser(email, pass);
			    if(user == null) {
			    	pw.print("<h3>Invalid User<h3>");
			    }
			    else {
			    	 pw.println("<h4>Authentication Successfull..!<h4>");
			    	 pw.print("<br>");
			    	 pw.println("ID:"+user.getUserId());
			    	 pw.print("<br>");
			    	 pw.println("Name:"+user.getFirstName()+" "+user.getLastName());
			    	 pw.print("<br>");
			    	 pw.println("Email:"+user.getEmail());
			    	 pw.print("<br>");
			    	 pw.println("Role:"+user.getRole());
			    }
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
