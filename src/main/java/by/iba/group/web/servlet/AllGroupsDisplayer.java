package by.iba.group.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.group.repository.GroupRepository;

public class AllGroupsDisplayer extends HttpServlet {
	
	private static final long serialVersionUID = -5414728086959648709L;
	
	
	
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 ServletContext sc = getServletContext();
	 GroupRepository groupRepository = (GroupRepository)sc.getAttribute("groupRepository");
	 req.setAttribute("groups", groupRepository.findAll());
	 RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/JSP/ShowAllGroups.jsp");
	 reqDisp.forward(req, resp);
   }
   
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   ServletContext sc = getServletContext();
	   GroupRepository groupRepository = (GroupRepository)sc.getAttribute("groupRepository");
	   String[] idS = req.getParameterValues("groupNumber");
	   if (idS != null && idS[0].length() > 0) {
	    	for(String s : idS) {
	    		groupRepository.remove(new Integer(s));
	    	}
	    } else {
	    	 System.out.println("No groups to delete");
	    }
	    sc.setAttribute("groupRepository", groupRepository);
	    doGet(req, resp);
   }	
}


