package by.iba.student.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.student.repository.StudentRepository;

public class AllStudentsDisplayer extends HttpServlet {
	
	private static final long serialVersionUID = -5414728086959648709L;
	
	
	
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 ServletContext sc = getServletContext();
	 StudentRepository studentRepository = (StudentRepository)sc.getAttribute("studentRepository");
	 req.setAttribute("students", studentRepository.findAll());
	 RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/JSP/ShowAllStudents.jsp");
	 reqDisp.forward(req, resp);
   }
   
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   ServletContext sc = getServletContext();
	   StudentRepository studentRepository = (StudentRepository)sc.getAttribute("studentRepository");
	   String[] idS = req.getParameterValues("id");
	   if (idS != null && idS[0].length() > 0) {
	    	for(String s : idS) {
	    		studentRepository.remove(s);
	    	}
	    } else {
	    	 System.out.println("No students to delete");
	    }
	    sc.setAttribute("studentRepository", studentRepository);
	    doGet(req, resp);
   }	
}

