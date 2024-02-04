package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

/**
 * Servlet implementation class Result
 */
@WebServlet("/result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student s1 = (Student) request.getAttribute("student");
		boolean getAdmisssion  = (boolean) request.getAttribute("getAdmission");
		
		
		try(PrintWriter pw = response.getWriter()){
			   

			int score =  Integer.parseInt(request.getParameter("testScore"));
			pw.print("Your Score is "+score);
			CourseDaoImpl cdao = (CourseDaoImpl) request.getAttribute("course_dao");
			if(getAdmisssion) {
				pw.print("<h3>Helloo"+" "+s1.getFirstName()+" "+s1.getLasrName());
				pw.print("<h4> Congralutation for getting Admission in the"+cdao.getCourseDetailById(s1.getCourse_id()).getName()+"</h4>");
			}
			else {
				pw.print("<h3>Helloo"+" "+request.getParameter("firstName")+" "+request.getParameter("lastName"));
				pw.print("<h4> Sorry You are not qualified in test :"+request.getParameter("course")+"</h4>");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
