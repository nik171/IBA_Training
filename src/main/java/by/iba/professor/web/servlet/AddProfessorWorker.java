package by.iba.professor.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.professor.common.Professor;
import by.iba.professor.repository.ProfessorRepository;

public class AddProfessorWorker extends HttpServlet {
	
	private static final long serialVersionUID = 6612429953285720369L;
	
	private ProfessorRepository professorRepository;
	
	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.professorRepository = (ProfessorRepository)sc.getAttribute("professorRepository");
	}
	
	
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 req.setAttribute("professors", professorRepository.findAll());
	 RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/JSP/AddProfessor.jsp");
	 reqDisp.forward(req, resp);
   }
   
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String firstName = req.getParameter("firstName");
	   String secondName = req.getParameter("secondName");
	   String fatherName = req.getParameter("fatherName");
	   professorRepository.create(new Professor(firstName, secondName, fatherName));
	   doGet(req, resp);
   }
	
}


