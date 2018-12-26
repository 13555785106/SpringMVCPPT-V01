package com.sample.model;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Product implements Serializable, HttpSessionBindingListener {
	private static final long serialVersionUID = 5784L;
	private long id;
	private String name;
	private String description;
	private float price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("valueBound " + arg0.getName() + "=" + arg0.getValue());
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("valueUnbound " + arg0.getName() + "=" + arg0.getValue());
	}
}