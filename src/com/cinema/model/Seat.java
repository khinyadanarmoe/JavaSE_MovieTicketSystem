package com.cinema.model;

public class Seat {

	private int seatId;
	private String seatType;
	private Theatre theatre;

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
}
