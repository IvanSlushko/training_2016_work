package io_serialization;

import java.io.Serializable;

public class Outer implements Serializable {

	private static final long serialVersionUID = 1;

	private String outerProp;

	@SuppressWarnings("unused")
	private String newProperty;

	private transient Inner innerObject;

	public Inner getInnerObject() {
		return innerObject;
	}

	public void setInnerObject(Inner innerObject) {
		this.innerObject = innerObject;
	}

	public String getOuterProp() {
		return outerProp;
	}

	public void setOuterProp(String outerProp) {
		this.outerProp = outerProp;
	}

	@Override
	public String toString() {
		return "Outer [outerProp=" + outerProp + ", innerObject=" + innerObject + "]";
	}

}