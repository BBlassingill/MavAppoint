package uta.mav.appoint.visitor;

import java.util.ArrayList;

import uta.mav.appoint.beans.AppointmentType;
import uta.mav.appoint.beans.CreateAdvisorBean;
import uta.mav.appoint.beans.CreateAppointmentTypeBean;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.AdminUser;
import uta.mav.appoint.login.AdvisorUser;

public class CreateAppointmentTypeVisitor extends Visitor{
		
	@Override
	public ArrayList<Object> check(AdminUser user,Object at){
		try{
			CreateAppointmentTypeBean ca = (CreateAppointmentTypeBean)at; //cast javabean
			AdvisorUser au = new AdvisorUser(ca.getEmail(), ca.getAdvisor());
			
			DatabaseManager dbm = new DatabaseManager();
			String result = dbm.createAppointmentType(au, ca);
			if (result.equals("Appointment Type added.")){
				user.setMsg("Appointment type created.");
			}
			else{
				user.setMsg("Error: Cannot create appointment type.");
			}
		}
		catch(Exception e){
			user.setMsg("Unable to create appointment type..");
		}
		return null;
	}
	
	@Override
	public ArrayList<Object> check(AdvisorUser user,Object at){
		try{
			CreateAppointmentTypeBean ca = (CreateAppointmentTypeBean)at; //cast javabean
			AdvisorUser au = new AdvisorUser(ca.getEmail(), ca.getAdvisor());
			
			DatabaseManager dbm = new DatabaseManager();
			String result = dbm.createAppointmentType(au, ca);
			if (result.equals("Appointment Type added.")){
				user.setMsg("Appointment type created.");
			}
			else{
				user.setMsg("Error: Cannot create appointment type.");
			}
		}
		catch(Exception e){
			user.setMsg("Unable to create appointment type..");
		}
		return null;
	}

}
