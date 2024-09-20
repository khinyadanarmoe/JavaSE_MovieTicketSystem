package com.cinema.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.cinema.dao.CinemaDao;
import com.cinema.dao.CustomerDao;
import com.cinema.dao.MovieDao;
import com.cinema.model.Cinema;
import com.cinema.model.Customer;
import com.cinema.model.Movie;

public class MainApp {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static CustomerDao customerDao = new CustomerDao();
	private static MovieDao movieDao = new MovieDao();
	private static CinemaDao cinemaDao = new CinemaDao();

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {

		getActionForCusotmer();
		getActionForMovie();
		getActionForCinema();
	}
	


	//CUSTOMER
	public static void actionForCusotmer() {

		System.out.println("Choose an action:");
		System.out.println("1: Find Customer by ID");
		System.out.println("2: Get all customers");
		System.out.println("3: Create new customer");
		System.out.println("4: Delete Customer by ID");
		System.out.println("5: Exit");
	}
	
	public static void getActionForCusotmer() throws SQLException, NumberFormatException, IOException {

		boolean inloop = true;

		do {

			actionForCusotmer();

			int choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				findCustomer();
				break;
			case 2:
				getAllCustomers();
				break;
			case 3:
				registerCustomer();
				break;
			case 4:
				destroyCustomer();
				break;
			case 5:
				inloop = false;
				System.out.println("Exit!");
				break;
			}
		}while (inloop);

	}

	private static void destroyCustomer() throws SQLException, NumberFormatException, IOException {
		System.out.print("Enter customer id: ");
		int id = Integer.parseInt(br.readLine());
		Customer customer = new Customer();
		customer.setId(id);
		customerDao.delete(customer);
		System.out.println(customer);

	}

	private static void registerCustomer() throws IOException, SQLException {

		System.out.print("Enter customer name: ");
		String name = br.readLine();

		Customer customer = new Customer();
		customer.setName(name);
		customerDao.create(customer);

	}

	private static void getAllCustomers() throws SQLException {
		List<Customer> customers = customerDao.getAll();

		for (Customer c : customers) {
			System.out.println(c);
		}

	}

	private static void findCustomer() throws NumberFormatException, IOException, SQLException {
		System.out.print("Enter customer id: ");
		int id = Integer.parseInt(br.readLine());
		Customer customer = customerDao.findbyId(id);
		System.out.println(customer);

	}
	
	
//MOVIES
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
		System.out.print("Enter customer id: ");
		int id = Integer.parseInt(br.readLine());
		Movie movie = movieDao.findbyId(id);
		System.out.println(movie);

	}
	

//CINEMA
	//CUSTOMER
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
		}while (inloop);

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

		for (Cinema c: cinemas) {
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
