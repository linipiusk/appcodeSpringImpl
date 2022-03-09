package com.ecommerce.java.entity;

public class SignupDetails_entity {

	private String username;
	private String passcode;
	private String firstname;
	private String lastname;
	private String userrole;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	@Override
	public String toString() {
		return "Signup [username=" + username + ", passcode=" + passcode + ", firstname=" + firstname + ", lastname="
				+ lastname + ", userrole=" + userrole + "]";
	}
	
}
