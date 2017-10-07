package uta.mav.appoint.beans;

import java.io.Serializable;

public class Advisor implements Serializable {
	/**
	 * JavaBean for Advisors db table
	 */
	private static final long serialVersionUID = -3734663824525723817L;
	String pname;
	String advisorEmail;
	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * @return the advisorEmail
	 */
	public String getAdvisorEmail() {
		return advisorEmail;
	}
	/**
	 * @param advisorEmail the advisorEmail to set
	 */
	public void setAdvisorEmail(String advisorEmail) {
		this.advisorEmail = advisorEmail;
	}
	
	@Override
	public String toString(){
		return	String.format("%10s %10s %s %s %s %s",this.getPname(),this.getAdvisorEmail());
	}
	
}
