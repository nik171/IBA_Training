package by.iba.group.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.group.common.Group;
import by.iba.group.repository.GroupRepository;

public class AddGroupWorker extends HttpServlet {
	
	private static final long serialVersionUID = 6612429953285720369L;
	
	private GroupRepository groupRepository;
	
	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.groupRepository = (GroupRepository)sc.getAttribute("groupRepository");
	}
	
	
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 req.setAttribute("groups", groupRepository.findAll());
	 RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/JSP/AddGroup.jsp");
	 reqDisp.forward(req, resp);
   }
   
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String averageMark = req.getParameter("averageMark");
	   groupRepository.create(new Group(new Double(averageMark)));
	   doGet(req, resp);
   }
	
}


