package com.cinema.main;

import java.io.IOException;
import java.sql.SQLException;
import com.cinema.service.CinemaService;
import com.cinema.service.CustomerService;
import com.cinema.service.MovieService;
import com.cinema.service.PaymentMethodService;

public class MainApp {

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {

		CustomerService.getActionForCusotmer();
		MovieService.getActionForMovie();
		CinemaService.getActionForCinema();
		PaymentMethodService.getActionForPaymentMethod();
	}

}
