package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
		response.setContentType("text/html");
	    HttpSession hs = request.getSession();
	    System.out.println("Session Id:"+hs.getId());
	    User user  = (User) hs.getAttribute("user-detail");
	    PrintWriter pw = response.getWriter();
	    pw.print("<h3>Logout Page..!!</h3>");
	    if(user!=null) {
	    	pw.print("<h3>"+user.toString()+"</h3>");
	    }
		  
		  			   
	}

}
