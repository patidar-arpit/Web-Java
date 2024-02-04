package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( value = "/test1",loadOnStartup = 1)

public class Servlet1 extends HttpServlet {

    
	@Override 
	public void init() {
		System.out.println("In init of Servlet1");
	}
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	         resp.setContentType("text/html");
	         
	         try(PrintWriter pw = resp.getWriter()){
	        	 pw.write("<h2> Welcome to the java EE<h2>");
	         }
	}

}
