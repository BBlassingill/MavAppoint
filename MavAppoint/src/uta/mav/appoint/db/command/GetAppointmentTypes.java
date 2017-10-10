package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import uta.mav.appoint.beans.AppointmentType;

public class GetAppointmentTypes extends SQLCmd{
	
	public GetAppointmentTypes(){
		super();
	}
	
	
	@Override
	public void queryDB(){
		try{
			String command = "SELECT APPOINTMENT_TYPES.userid,pname,type,duration FROM APPOINTMENT_TYPES,ADVISOR_SETTINGS where ADVISOR_SETTINGS.userid = APPOINTMENT_TYPES.userid";
			PreparedStatement statement = conn.prepareStatement(command);
			res = statement.executeQuery();	
		}
		catch(SQLException sq){
			System.out.printf(sq.toString());
		}
	}
	
	@Override
	public void processResult(){		
		AppointmentType at = new AppointmentType();
		try{
			while (res.next()){
				at.setUserId(res.getInt(1));
				at.setAdvisor(res.getString(2));
				at.setType(res.getString(3));
				at.setDuration(res.getInt(4));
				result.add(at);
				at = new AppointmentType();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
