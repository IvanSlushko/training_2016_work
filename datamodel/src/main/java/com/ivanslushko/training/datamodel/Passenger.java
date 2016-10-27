package com.ivanslushko.training.datamodel;

import java.sql.Date;

public class Passenger extends AbstractModel {

	private String fullName;
	private Date birthday;
	private String passport;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
	   @Override
	    public String toString() {
	        return getId() + "Passenger: " + fullName + ", birthday= " + birthday + " passport " + passport ;
	    }
}
