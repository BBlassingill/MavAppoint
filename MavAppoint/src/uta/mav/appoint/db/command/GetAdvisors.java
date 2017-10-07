package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import uta.mav.appoint.beans.Advisor;
import uta.mav.appoint.beans.Appointment;

public class GetAdvisors extends SQLCmd{
	
	public GetAdvisors(){
		super();
	}
	
	
	@Override
	public void queryDB(){
		try{
			String command = "SELECT pname,ADVISOR_SETTINGS.email FROM USER,ADVISOR_SETTINGS WHERE ROLE=? AND USER.userid = ADVISOR_SETTINGS.userid";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setString(1,"advisor");
			res = statement.executeQuery();	
		}
		catch(SQLException sq){
			System.out.printf(sq.toString());
		}
	}
	
	@Override
	public void processResult(){		
		Advisor adv = new Advisor();
		try{
			while (res.next()){
				adv.setPname(res.getString(1));
				adv.setAdvisorEmail(res.getString(2));
				result.add(adv);
				adv = new Advisor();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}
