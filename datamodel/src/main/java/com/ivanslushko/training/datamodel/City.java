package com.ivanslushko.training.datamodel;

public class City extends AbstractModel {

	private String city_ru;
	private String city_en;
	private String city_by;
	
	public String getCity_ru() {
		return city_ru;
	}
	public void setCity_ru(String city_ru) {
		this.city_ru = city_ru;
	}
	public String getCity_en() {
		return city_en;
	}
	public void setCity_en(String city_en) {
		this.city_en = city_en;
	}
	public String getCity_by() {
		return city_by;
	}
	public void setCity_by(String city_by) {
		this.city_by = city_by;
	}
	@Override
	public String toString() {
		return "City [city_ru=" + city_ru + ", city_en=" + city_en + ", city_by=" + city_by + "]";
	}
	
	
}
