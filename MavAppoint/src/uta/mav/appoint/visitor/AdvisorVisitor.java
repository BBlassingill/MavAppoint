package uta.mav.appoint.visitor;

import java.util.ArrayList;

import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.AdminUser;

public class AdvisorVisitor extends Visitor {
	@Override
	public ArrayList<Object> check(AdminUser user,Object o){
		try{
			DatabaseManager dbm = new DatabaseManager();
			ArrayList<Object> advisors = dbm.getAdvisors();
			return advisors;
		}
		catch(Exception e){
			return null;
		}
	}

}
