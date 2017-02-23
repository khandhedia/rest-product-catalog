package com.rnd.pc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DummyObject {
	
	private String dummy;

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

	public DummyObject(String dummy) {
		super();
		this.dummy = dummy;
	}

	public DummyObject() {
		super();
	}
	
}
