package by.iba.student.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.student.common.Student;
import by.iba.student.repository.StudentRepository;

public class AddStudentWorker extends HttpServlet {

	private static final long serialVersionUID = -5414728086959648709L;
	
	private StudentRepository studentRepository;
	
	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.studentRepository = (StudentRepository)sc.getAttribute("studentRepository");
	}
	
	
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 req.setAttribute("students", studentRepository.findAll());
	 RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/JSP/AddStudent.jsp");
	 reqDisp.forward(req, resp);
   }
   
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String firstName = req.getParameter("firstName");
	   String secondName = req.getParameter("secondName");
	   studentRepository.create(new Student(firstName, secondName));
	   doGet(req, resp);
   }
	
}

