package uta.mav.appoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uta.mav.appoint.beans.AppointmentType;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.visitor.AppointmentTypeVisitor;
import uta.mav.appoint.visitor.Visitor;

public class ManageAppointmentTypeServlet extends HttpServlet {
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
				ArrayList<Object> appointmentTypes = user.accept(v,null);
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		if (user != null){
			try{
					header = "templates/" + user.getHeader() + ".jsp";
					
					List<String> parametersToUpdate = new ArrayList<String>();
					parametersToUpdate.add(request.getParameter("userid_to_edit"));
					parametersToUpdate.add(request.getParameter("type_to_edit"));
					parametersToUpdate.add(request.getParameter("duration_to_edit"));
					parametersToUpdate.add(request.getParameter("old_type"));
					
					DatabaseManager dbm = new DatabaseManager();
					Boolean result = dbm.updateAppointmentType(parametersToUpdate);
					
					if (result == true){
						response.setHeader("Refresh","2; URL=view_appointment_types");
						request.getRequestDispatcher("/WEB-INF/jsp/views/success.jsp").forward(request,response);
					}
			}
			
			catch(Exception e){
				System.out.printf("Error in ManageAppointmentTypes Post : " + e.toString());
			}
		}
		
		else{
			header = "templates/header.jsp";
		}
		
	}

}
