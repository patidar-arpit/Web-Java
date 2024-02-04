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
		  
		  Cookie cookie[] = request.getCookies();
		  PrintWriter pw = response.getWriter();
		  pw.print("<h3> Logging Out Page..!!");
		  if(cookie == null) {
			  pw.print("<h3>Session Handling Failed By Cookie Mang</h3");
		  }
		  for(Cookie c1 :cookie) {
			  if(c1!= null) {
				  pw.print("<h3>"+c1.getName()+" "+c1.getValue()+"</h3>");
			  }
		  }
			   
	}

}
