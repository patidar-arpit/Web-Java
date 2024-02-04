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

import dao.UserDaoImpl;
import pojos.User;

@WebServlet(value = "/authenticate", loadOnStartup = 69)
public class LoginServlet extends HttpServlet {
	UserDaoImpl usd;

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

		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String pass = request.getParameter("pass");

			User user = usd.authenticateUser(email, pass);
			if (user == null) {
				pw.print("<h3>Invalid User<h3>");
			} else {
//			    	 pw.println("<h4>Authentication Successfull..!<h4>");   // it not send the rsponse it is stored in the buffer and when pw is closed it will send 
//			    	  //pw.flush();   we cannot write or forcefully send the date before the response.sendReq();

				HttpSession hs = request.getSession();
				hs.setAttribute("user-detail",user);
				System.out.println("session id:"+hs.getId());
				if (user.getRole().equals("voter")) {
					if (user.isVotingStatus())

						response.sendRedirect("logout"); // it will clear the buffer and redirect to the logout
															// page/servlet
					else
						response.sendRedirect("candidate_list");
				} else {
					response.sendRedirect("admin");    ///Page Navigation by the browser without clicking by user
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
