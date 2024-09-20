package com.cinema.model;

public class Movie {
	private int id;
	private String name;
	private String duration;

	public Movie() {

	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name  + ", duration=" + duration + "]";
	}
}
