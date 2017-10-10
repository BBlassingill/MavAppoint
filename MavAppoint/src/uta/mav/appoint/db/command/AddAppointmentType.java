package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;

import uta.mav.appoint.beans.AppointmentType;
import uta.mav.appoint.beans.CreateAppointmentTypeBean;
import uta.mav.appoint.login.AdminUser;
import uta.mav.appoint.login.AdvisorUser;
import uta.mav.appoint.login.FacultyUser;
import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.login.StudentUser;

public class AddAppointmentType extends SQLCmd {
		String type;
		int duration;
		int userid;
		String resu;
		
		public AddAppointmentType(CreateAppointmentTypeBean ca,int id){
			type = ca.getType();
			duration = ca.getDuration();
			userid = id;
			resu = "";
		}
		
		@Override
		public void queryDB(){
			try{
				String command = "INSERT INTO appointment_types (userid, type, duration)"
								+ " values(?,?,?)";
				PreparedStatement statement = conn.prepareStatement(command); 
				statement.setInt(1,userid);
				statement.setString(2,type);
				statement.setInt(3,duration);
				statement.executeUpdate();
				resu = "Appointment Type added.";
				}
			catch (Exception e){
				System.out.println(e);	
			}
			
		}
		
		@Override
		public void processResult(){
			result.add(resu);
			
		}	
}

