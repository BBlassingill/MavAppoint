package uta.mav.appoint.visitor;

import java.util.ArrayList;

import uta.mav.appoint.beans.AppointmentType;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.AdminUser;
import uta.mav.appoint.login.AdvisorUser;

public class AppointmentTypeVisitor extends Visitor {
	@Override
	public ArrayList<Object> check(AdminUser user,Object o){
		try{
			DatabaseManager dbm = new DatabaseManager();
			ArrayList<Object> appointmentTypes = dbm.getAppointmentTypes();
			return appointmentTypes;
		}
		catch(Exception e){
			return null;
		}
	}
	
	@Override
	public ArrayList<Object> check(AdvisorUser user,Object o){
		try{
			DatabaseManager dbm = new DatabaseManager();
			ArrayList<Object> appointmentTypes = dbm.getAppointmentTypesByUser((String) o);
			return appointmentTypes;
		}
		catch(Exception e){
			return null;
		}
	}

}

