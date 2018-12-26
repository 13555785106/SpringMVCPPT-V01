package com.app12306.db.model;

public class Station {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Station [name=" + name + "]";
	}

}
