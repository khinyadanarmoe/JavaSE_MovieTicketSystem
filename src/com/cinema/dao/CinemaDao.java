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

public class CinemaDao extends AbstractDao<Cinema>{
	private PgSqlConnectionFactory connectionFactory;

	public CinemaDao() {
		this.connectionFactory = new PgSqlConnectionFactory();
	}

	@Override
	public Cinema findbyId(int id) throws SQLException {
		String query = "select * from cinemas where id = ?";
		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		
			preparedStatement.setInt(1, id); 

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					Cinema cinema = new Cinema();
					cinema.setId(resultSet.getInt("id"));
					cinema.setName(resultSet.getString("name"));
					return cinema;
				}
			}
		}
		return null;
	}

	@Override
	public List<Cinema> getAll() throws SQLException {
		String query = "select * from cinemas";

		List<Cinema> cinemas = new ArrayList<>();

		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					Cinema cinema = new Cinema();
					cinema.setId(resultSet.getInt("id"));
					cinema.setName(resultSet.getString("name"));
					cinemas.add(cinema);
				}
				return cinemas;
			}
		}

	}

	@Override
	public void create(Cinema cinmea) throws SQLException {
		String query = "insert into cinemas (name) values (?)";

		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, cinmea.getName());

			preparedStatement.executeUpdate();

		}
	}

	@Override
	public void delete(Cinema cinmea) throws SQLException {
		String query = "delete from cinemas where id = ?"; 

		try (Connection connection = this.connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, cinmea.getId());

			preparedStatement.executeUpdate(); 
		}
	}
}
