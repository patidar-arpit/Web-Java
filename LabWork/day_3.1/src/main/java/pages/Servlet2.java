package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */

public class Servlet2 extends HttpServlet {
     
	@Override
	public void init() {
		System.out.println("In init of Servlet2");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			    pw.write("<h1> Display Content using xml tags<h1>");
		}
	}

}
