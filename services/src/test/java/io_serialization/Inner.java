package io_serialization;

public class Inner {

	private String innerProp = "test";

	public String getInnerProp() {
		return innerProp;
	}

	public void setInnerProp(String innerProp) {
		this.innerProp = innerProp;
	}

	@Override
	public String toString() {
		return "Inner [innerProp=" + innerProp + "]";
	}

}