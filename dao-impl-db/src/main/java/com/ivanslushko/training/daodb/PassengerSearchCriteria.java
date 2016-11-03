package com.ivanslushko.training.daodb;

import java.util.Date;

import com.ivanslushko.training.datamodel.Passenger2;

public class PassengerSearchCriteria {

	private Date minDateRelease;
	private Date maxDateRelease;
	private String fullName;
	private String passport;
	private Integer passengerId;

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPassport() {
		return passport;
	}

	public void setMinDateRelease(Date minDateRelease) {
		this.minDateRelease = minDateRelease;
	}

	public Date getMinDateRelease() {
		return minDateRelease;
	}

	public void setMaxDateRelease(Date maxDateRelease) {
		this.maxDateRelease = maxDateRelease;
	}

	public Date getMaxDateRelease() {
		return maxDateRelease;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public boolean isEmpty() {
		return minDateRelease == null && maxDateRelease == null && fullName == null && passport == null
				&& passengerId == null;
	}

	public boolean accept(Passenger2 passenger2) {
		return acceptMinDateRelease(passenger2.getBirthday()) && acceptMaxDateRelease(passenger2.getBirthday())
				&& acceptFullName(passenger2.getFullName()) && acceptPassport(passenger2.getPassport())
				&& acceptPassengerId(passenger2.getId());
	}

	private boolean acceptPassengerId(Integer passengerId) {
		return this.passengerId == null || passengerId.equals(passengerId);
	}

	private boolean acceptPassport(String passport) {
		return this.passport == null || this.passport.equals(passport);
	}

	private boolean acceptFullName(String fullName) {
		return this.fullName == null || this.fullName.equals(fullName);
	}

	private boolean acceptMaxDateRelease(Date dateRelease) {
		return maxDateRelease == null || maxDateRelease.before(dateRelease);
	}

	private boolean acceptMinDateRelease(Date dateRelease) {
		return minDateRelease == null || minDateRelease.before(dateRelease);
	}

}
