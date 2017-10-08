package uta.mav.appoint;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.visitor.AdvisorVisitor;
import uta.mav.appoint.visitor.DeleteAdvisorVisitor;
import uta.mav.appoint.visitor.Visitor;

public class ViewAdvisorsServlet extends HttpServlet {
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
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		if (user != null){
			try{
				header = "templates/" + user.getHeader() + ".jsp";
				Visitor v = new DeleteAdvisorVisitor();

				String email = request.getParameter("delete_button");
				user.accept(v,(Object)email);
				
				v = new AdvisorVisitor();
				ArrayList<Object> advisors = user.accept(v,null);
				if (advisors.size() != 0 && advisors != null){
					session.removeAttribute("advisors");
					session.setAttribute("advisors", advisors);
					response.setHeader("Refresh","2; URL=view_advisors");
				}
			}
			
			catch(Exception e){
				System.out.printf("Error in Servlet: " + e.toString()+"\n");
			}			
		}
		
		else{
			header = "templates/header.jsp";
		}
		
		request.setAttribute("includeHeader", header);
		request.getRequestDispatcher("/WEB-INF/jsp/views/view_advisors.jsp").forward(request,response);
	}
}
