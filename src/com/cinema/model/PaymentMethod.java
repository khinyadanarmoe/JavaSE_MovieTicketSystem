package com.cinema.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethod {

	private int id;
	private String name;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Payment method [id=" + id + ", name=" + name + "]";
	}
}
