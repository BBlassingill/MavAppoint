package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import uta.mav.appoint.beans.AppointmentType;

public class UpdateAppointmentType extends SQLCmd {

	String type;
	String oldType;
	int duration;
	int userId;
	Boolean b = false;
	
	public UpdateAppointmentType(List<String> parameters){
		userId = Integer.parseInt(parameters.get(0));
		type = parameters.get(1);
		duration = Integer.parseInt(parameters.get(2));
		oldType = parameters.get(3);
	}
	
	public void queryDB(){
		try{
			
			String command = "UPDATE APPOINTMENT_TYPES SET type=?,duration=? where userid=? and type=?";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setString(1, type);
			statement.setInt(2, duration);
			statement.setInt(3, userId);
			statement.setString(4, oldType);
			statement.executeUpdate();
						
			b=true;
		}
		catch(SQLException sq){
			System.out.println(sq.toString());
		}
	}
	
	public void processResult(){
		result.add(b);
	}
}