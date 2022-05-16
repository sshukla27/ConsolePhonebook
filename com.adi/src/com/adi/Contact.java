package com.adi;

public class Contact {

	String name;
	long mobileNo;
	String emailId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Contact() {
		super();
		this.name = "";
		this.mobileNo = 0;
		this.emailId = "";
	}

	public Contact(String name, long mobileNo, String emailId) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
}
