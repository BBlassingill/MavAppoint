package uta.mav.appoint.visitor;

import java.util.ArrayList;

import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.AdminUser;

public class DeleteAdvisorVisitor extends Visitor{

	@Override
	public ArrayList<Object> check(AdminUser user,Object o){
		try{
			DatabaseManager dbm = new DatabaseManager();
			String email = (String) o;
			
			Boolean result = dbm.deleteAdvisor(email);
			
			if (result == true){
				user.setMsg("Advisor has been deleted from the system.");
			}
			
			else{
				user.setMsg("Unable to delete advisor.");
			}
		}
		
		catch(Exception e){
			user.setMsg("Unable to delete advisor. Something went wrong...");
		}
		
		return null;
	}

}
