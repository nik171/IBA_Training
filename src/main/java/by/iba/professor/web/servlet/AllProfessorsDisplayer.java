package by.iba.professor.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.professor.repository.ProfessorRepository;

public class AllProfessorsDisplayer extends HttpServlet {
	
	private static final long serialVersionUID = -5414728086959648709L;
	
	
	
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 ServletContext sc = getServletContext();
	 ProfessorRepository professorRepository = (ProfessorRepository)sc.getAttribute("professorRepository");
	 req.setAttribute("professors", professorRepository.findAll());
	 RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/JSP/ShowAllProfessors.jsp");
	 reqDisp.forward(req, resp);
   }
   
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   ServletContext sc = getServletContext();
	   ProfessorRepository professorRepository = (ProfessorRepository)sc.getAttribute("professorRepository");
	   String[] idS = req.getParameterValues("id");
	   if (idS != null && idS[0].length() > 0) {
	    	for(String s : idS) {
	    		professorRepository.remove(s);
	    	}
	    } else {
	    	 System.out.println("No professors to delete");
	    }
	    sc.setAttribute("professorRepository", professorRepository);
	    doGet(req, resp);
   }	
}


