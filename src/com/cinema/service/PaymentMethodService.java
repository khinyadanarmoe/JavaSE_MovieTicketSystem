package com.cinema.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.cinema.dao.MovieDao;
import com.cinema.dao.PaymentMethodDao;
import com.cinema.model.Movie;
import com.cinema.model.PaymentMethod;

public class PaymentMethodService {

	//PAYMENT

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static PaymentMethodDao paymentMethodDao = new PaymentMethodDao();

	public static void actionForPaymentMethod() {

		System.out.println("Choose an action:");
		System.out.println("1: Find payment method by ID");
		System.out.println("2: Get all payment methods");
		System.out.println("3: Create new payment method");
		System.out.println("4: Delete payment method by ID");
		System.out.println("5: Exit");
	}

	public static void getActionForPaymentMethod() throws SQLException, NumberFormatException, IOException {

		boolean inloop = true;

		do {

			actionForPaymentMethod();

			int choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				findPaymentMethod();
				break;
			case 2:
				getAllPaymentMethods();
				break;
			case 3:
				registerPaymentMethod();
				break;
			case 4:
				destroyPaymentMethod();
				break;
			case 5:
				inloop = false;
				System.out.println("Exit!");
				break;
			}
		}while (inloop);

	}

	private static void destroyPaymentMethod() throws SQLException, NumberFormatException, IOException {
		System.out.print("Enter payment method id: ");
		int id = Integer.parseInt(br.readLine());
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setId(id);
		paymentMethodDao.delete(paymentMethod);
		System.out.println(paymentMethod);

	}

	private static void registerPaymentMethod() throws IOException, SQLException {

		System.out.print("Enter movie name: ");
		String name = br.readLine();

		
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setName(name);
		paymentMethodDao.create(paymentMethod);

	}

	private static void getAllPaymentMethods() throws SQLException {
		List<PaymentMethod> paymentMethods = paymentMethodDao.getAll();

		for (PaymentMethod p : paymentMethods) {
			System.out.println(p);
		}

	}

	private static void findPaymentMethod() throws NumberFormatException, IOException, SQLException {
		System.out.print("Enter customer id: ");
		int id = Integer.parseInt(br.readLine());
		PaymentMethod paymentMethod = paymentMethodDao.findbyId(id);
		System.out.println(paymentMethod);

	}
}
