package com.ivanslushko.training.web.model;

import java.sql.Date;

public class PassengerModel {

	private Long id;
	private String full_name;
	private Date birthday;
	private String passport;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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
		return "PlaneModel [id=" + id + ", full name " + full_name + ", birthday " + birthday + ", passport " + passport
				+ " ]";
	}

}
