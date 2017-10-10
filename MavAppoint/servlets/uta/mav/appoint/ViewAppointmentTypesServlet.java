package uta.mav.appoint;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uta.mav.appoint.beans.AppointmentType;
import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.visitor.AppointmentTypeVisitor;
import uta.mav.appoint.visitor.DeleteAppointmentTypeVisitor;
import uta.mav.appoint.visitor.Visitor;

public class ViewAppointmentTypesServlet extends HttpServlet {
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
				Visitor v = new AppointmentTypeVisitor();
				
				ArrayList<Object> appointmentTypes = user.accept(v,user.getPname());
				if (appointmentTypes.size() != 0 &&appointmentTypes != null){
					session.setAttribute("appointmentTypes", appointmentTypes);
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
		request.getRequestDispatcher("/WEB-INF/jsp/views/view_appointment_types.jsp").forward(request, response);
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
				Visitor v = new DeleteAppointmentTypeVisitor();

				AppointmentType toDelete = new AppointmentType();
				toDelete.setUserId(Integer.parseInt(request.getParameter("userid_to_delete")));
				toDelete.setType(request.getParameter("type_to_delete"));
				toDelete.setDuration(Integer.parseInt(request.getParameter("duration_to_delete")));
								
				user.accept(v,(Object)toDelete);
				
				v = new AppointmentTypeVisitor();
				
				ArrayList<Object> appointmentTypes = user.accept(v,user.getPname());
				if (appointmentTypes.size() != 0 && appointmentTypes != null){
					session.removeAttribute("appointmentTypes");
					session.setAttribute("appointmentTypes", appointmentTypes);
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
		request.getRequestDispatcher("/WEB-INF/jsp/views/view_appointment_types.jsp").forward(request,response);
	}

}
