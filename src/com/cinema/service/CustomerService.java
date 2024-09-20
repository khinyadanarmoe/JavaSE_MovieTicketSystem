package com.cinema.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.cinema.dao.CustomerDao;
import com.cinema.dao.MovieDao;
import com.cinema.model.Customer;

public class CustomerService {

	// CUSTOMER

	private static CustomerDao customerDao = new CustomerDao();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
		} while (inloop);

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
}
