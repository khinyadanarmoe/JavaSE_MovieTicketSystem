package com.cinema.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;

public class MovieService {

	//MOVIES
	private static MovieDao movieDao = new MovieDao();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void actionForMovie() {

		System.out.println("Choose an action:");
		System.out.println("1: Find Movie by ID");
		System.out.println("2: Get all movies");
		System.out.println("3: Create new movie");
		System.out.println("4: Delete movie by ID");
		System.out.println("5: Exit");
	}

	public static void getActionForMovie() throws SQLException, NumberFormatException, IOException {

		boolean inloop = true;

		do {

			actionForMovie();

			int choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				findMovie();
				break;
			case 2:
				getAllMovies();
				break;
			case 3:
				registerMovie();
				break;
			case 4:
				destroyMovie();
				break;
			case 5:
				inloop = false;
				System.out.println("Exit!");
				break;
			}
		}while (inloop);

	}

	private static void destroyMovie() throws SQLException, NumberFormatException, IOException {
		System.out.print("Enter movie id: ");
		int id = Integer.parseInt(br.readLine());
		Movie movie = new Movie();
		movie.setId(id);
		movieDao.delete(movie);
		System.out.println(movie);

	}

	private static void registerMovie() throws IOException, SQLException {

		System.out.print("Enter movie name: ");
		String name = br.readLine();

		System.out.print("Enter movie duration: ");
		String duration = br.readLine();
		
		Movie movie = new Movie();
		movie.setName(name);
		movie.setDuration(duration);
		movieDao.create(movie);

	}

	private static void getAllMovies() throws SQLException {
		List<Movie> movies = movieDao.getAll();

		for (Movie m : movies) {
			System.out.println(m);
		}

	}

	private static void findMovie() throws NumberFormatException, IOException, SQLException {
		System.out.print("Enter movie id: ");
		int id = Integer.parseInt(br.readLine());
		Movie movie = movieDao.findbyId(id);
		System.out.println(movie);

	}
}
