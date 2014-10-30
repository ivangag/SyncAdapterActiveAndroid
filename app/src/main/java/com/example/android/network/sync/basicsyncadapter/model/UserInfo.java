package com.example.android.network.sync.basicsyncadapter.model;

public class UserInfo {
	
	private UserType userType = UserType.UNKWOWN;
	
	private boolean isLogged;
	
	private boolean isAnagPresent;
	
	private String userIdentification;
		
	private String firstName;
	
	private String lastName;
	//private T userExtra;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new  StringBuilder();
		return sb.append(this.firstName).append("-")
				.append(this.lastName).append("-")
				.append(this.getUserIdentification()).append("-")
				.append(this.isLogged)
				.toString();
	}

	public String getUserIdentification() {
		return userIdentification;
	}

	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}

	public boolean getAnagPresent() {
		return isAnagPresent;
	}

	public void setAnagPresent(boolean isAnagPresent) {
		this.isAnagPresent = isAnagPresent;
	}

}
