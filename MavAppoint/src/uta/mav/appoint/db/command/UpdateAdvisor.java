package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import uta.mav.appoint.beans.Advisor;
import uta.mav.appoint.beans.Appointment;

public class UpdateAdvisor extends SQLCmd {

	String name;
	String email;
	int id;
	Boolean b = false;
	
	public UpdateAdvisor(Advisor a){
		name = a.getPname();
		email = a.getAdvisorEmail();
		id = a.getID();
	}
	
	public void queryDB(){
		try{
			
			String command = "UPDATE user SET email=? where userid=?";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setString(1, email);
			statement.setInt(2, id);
			statement.executeUpdate();
			
			command = "UPDATE advisor_settings SET pname=?, email=? where userid=?";
			statement = conn.prepareStatement(command);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setInt(3, id);
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
