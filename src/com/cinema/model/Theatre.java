package com.cinema.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private int id;
	private String name;
	private List<Seat> seats = new ArrayList<Seat>();
	private Cinema cinema;

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
