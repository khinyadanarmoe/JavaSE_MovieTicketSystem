package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cinema.database.PgSqlConnectionFactory;
import com.cinema.model.Cinema;
import com.cinema.model.Customer;
import com.cinema.model.Movie;
import com.cinema.model.PaymentMethod;

public class PaymentMethodDao extends AbstractDao<PaymentMethod>{
	private PgSqlConnectionFactory connectionFactory;

	public PaymentMethodDao() {
		this.connectionFactory = new PgSqlConnectionFactory();
	}

	@Override
	public PaymentMethod findbyId(int id) throws SQLException {
		String query = "select * from payment_methods where id = ?";
		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		
			preparedStatement.setInt(1, id); 

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					PaymentMethod paymentMethod = new PaymentMethod();
					paymentMethod.setId(resultSet.getInt("id"));
					paymentMethod.setName(resultSet.getString("name"));
					return paymentMethod;
				}
			}
		}
		return null;
	}

	@Override
	public List<PaymentMethod> getAll() throws SQLException {
		String query = "select * from payment_methods";

		List<PaymentMethod> paymentMethods = new ArrayList<>();

		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					PaymentMethod paymentMethod = new PaymentMethod();
					paymentMethod.setId(resultSet.getInt("id"));
					paymentMethod.setName(resultSet.getString("name"));
					paymentMethods.add(paymentMethod);
				}
				return paymentMethods;
			}
		}

	}

	@Override
	public void create(PaymentMethod paymentMethod) throws SQLException {
		String query = "insert into payment_methods (name) values (?)";

		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, paymentMethod.getName());

			preparedStatement.executeUpdate();

		}
	}

	@Override
	public void delete(PaymentMethod paymentMethod) throws SQLException {
		String query = "delete from payment_methods where id = ?"; 

		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, paymentMethod.getId());

			preparedStatement.executeUpdate(); 
		}
	}
}
