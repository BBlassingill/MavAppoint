package uta.mav.appoint;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uta.mav.appoint.beans.Advisor;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.visitor.AdvisorVisitor;
import uta.mav.appoint.visitor.Visitor;

public class ManageAdvisorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	HttpSession session;
	String header;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		
		if (user != null){
			try{
				header = "templates/" + user.getHeader() + ".jsp";
				Visitor v = new AdvisorVisitor();
				ArrayList<Object> advisors = user.accept(v,null);
				if (advisors.size() != 0 &&advisors != null){
					session.setAttribute("advisors", advisors);
				}
			}
			catch(Exception e){
				System.out.printf(e.toString());
			}
		}
		else{
			header = "templates/header.jsp";
		}
		
		request.setAttribute("includeHeader", header);
		request.getRequestDispatcher("/WEB-INF/jsp/views/view_advisors.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		if (user != null){
			try{
					header = "templates/" + user.getHeader() + ".jsp";
					Advisor a = new Advisor();
					
					a.setID(Integer.parseInt(request.getParameter("advisorID")));
					a.setPname(request.getParameter("advisorName"));
					a.setAdvisorEmail(request.getParameter("advisorEmail"));

					DatabaseManager dbm = new DatabaseManager();
					Boolean result = dbm.updateAdvisor(a);
					
					if (result == true){
						response.setHeader("Refresh","2; URL=view_advisors");
						request.getRequestDispatcher("/WEB-INF/jsp/views/success.jsp").forward(request,response);
					}
			}
			
			catch(Exception e){
				System.out.printf("Error in ManageAdvisor Post : " + e.toString());
			}
		}
		
		else{
			header = "templates/header.jsp";
		}
		
	}
}
