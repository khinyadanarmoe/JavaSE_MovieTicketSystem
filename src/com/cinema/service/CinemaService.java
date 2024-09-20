package com.cinema.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.cinema.dao.CinemaDao;
import com.cinema.model.Cinema;

public class CinemaService {

	// CINEMA

	private static CinemaDao cinemaDao = new CinemaDao();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void actionForCinema() {

		System.out.println("Choose an action:");
		System.out.println("1: Find Cinema by ID");
		System.out.println("2: Get all cinemas");
		System.out.println("3: Create new cinema");
		System.out.println("4: Delete cinema by ID");
		System.out.println("5: Exit");
	}

	public static void getActionForCinema() throws SQLException, NumberFormatException, IOException {

		boolean inloop = true;

		do {

			actionForCinema();

			int choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				findCinema();
				break;
			case 2:
				getAllCinemas();
				break;
			case 3:
				registerCinema();
				break;
			case 4:
				destroyCinema();
				break;
			case 5:
				inloop = false;
				System.out.println("Exit!");
				break;
			}
		} while (inloop);

	}

	private static void destroyCinema() throws SQLException, NumberFormatException, IOException {
		System.out.print("Enter cinema id: ");
		int id = Integer.parseInt(br.readLine());
		Cinema cinema = new Cinema();
		cinema.setId(id);
		cinemaDao.delete(cinema);
		System.out.println(cinema);

	}

	private static void registerCinema() throws IOException, SQLException {

		System.out.print("Enter cinema name: ");
		String name = br.readLine();

		Cinema cinema = new Cinema();
		cinema.setName(name);
		cinemaDao.create(cinema);

	}

	private static void getAllCinemas() throws SQLException {
		List<Cinema> cinemas = cinemaDao.getAll();

		for (Cinema c : cinemas) {
			System.out.println(c);
		}

	}

	private static void findCinema() throws NumberFormatException, IOException, SQLException {
		System.out.print("Enter customer id: ");
		int id = Integer.parseInt(br.readLine());
		Cinema cinema = cinemaDao.findbyId(id);
		System.out.println(cinema);

	}
}
