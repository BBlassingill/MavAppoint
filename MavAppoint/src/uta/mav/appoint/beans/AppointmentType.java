package uta.mav.appoint.beans;

import java.io.Serializable;

public class AppointmentType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6325941024133099928L;
	int userId;
	String type;
	int duration;
	String email;
	String advisor;
	
	
	/**
	 * @return the id
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param id the id to set
	 */
	public void setUserId(int id) {
		this.userId = id;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param advisor the advisor to set
	 */
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	/**
	 * @return the advisor
	 */
	public String getAdvisor() {
		return advisor;
	}
}
