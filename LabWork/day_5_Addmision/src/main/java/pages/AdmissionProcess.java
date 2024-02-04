package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;
import utils.DBUtils;

@WebServlet("/admission_process")
public class AdmissionProcess extends HttpServlet {
	private  CourseDaoImpl cdao;
	private StudentDaoImpl sdao;
	
	public void init() throws ServletException {
		  try {
			    DBUtils.openConnection();
			    cdao = new CourseDaoImpl();
			    sdao = new StudentDaoImpl();
			    
		  } 
		  catch (SQLException e) {
			  e.printStackTrace();
		}      
		 
	}

	
	public void destroy() {
	     try {
			DBUtils.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		response.setContentType("text/html");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int score  = Integer.parseInt(request.getParameter("testScore"));
		String course = request.getParameter("course");
		 
		boolean getAdmission = false;
	   RequestDispatcher rd  =request.getRequestDispatcher("result");

		
		try{
			  System.out.println(firstName+" "+lastName+" "+email+" "+score+" "+course);
			  Course c = cdao.getCourseDetail(course);
			  if(c.getMin_score()>score) {
				 getAdmission  = false;
				 request.setAttribute("getAdmission", getAdmission);
				 rd.forward(request, response);
			  }
			  else {
				    getAdmission = true;
				    sdao.addStudent(firstName,lastName,email,score,c.getCourse_id());
				    Student s1 = sdao.getStudentByemail(email);
                    request.setAttribute("course_dao", cdao);
				    if(s1!=null) {
					  request.setAttribute("student",s1);
					  request.setAttribute("getAdmission", getAdmission);
					  rd.forward(request, response);
				  }
				  else {
					System.out.println("Session failed..!");
				  }
			  }
			 
		 }
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
