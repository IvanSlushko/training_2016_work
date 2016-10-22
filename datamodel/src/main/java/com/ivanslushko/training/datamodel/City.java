package com.ivanslushko.training.datamodel;

public class City extends AbstractModel {

	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    @Override
    public String toString() {
        return "Gorod [city=" + city + ", getId()=" + getId() + "]";
    }

}
