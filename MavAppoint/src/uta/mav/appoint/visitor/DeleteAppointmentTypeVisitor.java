package uta.mav.appoint.visitor;

import java.util.ArrayList;

import uta.mav.appoint.beans.AppointmentType;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.AdminUser;
import uta.mav.appoint.login.AdvisorUser;

public class DeleteAppointmentTypeVisitor extends Visitor {
	@Override
	public ArrayList<Object> check(AdminUser user, Object o){
		try{
			DatabaseManager dbm = new DatabaseManager();
			Boolean result = dbm.deleteAppointmentType((AppointmentType) o);
			
			if (result == true){
				user.setMsg("Appointment Type has been deleted from the system.");
			}
			
			else{
				user.setMsg("Unable to delete appointment type.");
			}
		}
		
		catch(Exception e){
			user.setMsg("Unable to delete appointment type. Something went wrong...");
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Object> check(AdvisorUser user,Object o){
		try{
			DatabaseManager dbm = new DatabaseManager();			
			Boolean result = dbm.deleteAppointmentType((AppointmentType) o);
			
			if (result == true){
				user.setMsg("Appointment Type has been deleted from the system.");
			}
			
			else{
				user.setMsg("Unable to delete appointment type.");
			}
		}
		
		catch(Exception e){
			user.setMsg("Unable to delete appointment type. Something went wrong...");
		}
		
		return null;
	}

}
