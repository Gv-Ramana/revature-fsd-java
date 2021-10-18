package com.app.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.CustomerDao;
import com.app.dao.Util;
import com.app.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	public static int currentCustomerId;

	public Customer get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Customer customer) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into customer (first_name, last_name,email_id, password) values (?, ?, ?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customer.getfirstname());
			statement.setString(2, customer.getlastname());
			statement.setString(3, customer.getUserId());
			statement.setString(4, customer.getPassword());
			statement.executeUpdate();
		}

	}

	public void update(Customer customer) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	public Customer getCustomerUserId(String userId) throws SQLException {
		Customer customer = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from customer where email_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,  userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentCustomerId = resultSet.getInt("id");
				String firstname = resultSet.getString("first_name");
				String lastname = resultSet.getString("last_name");
				String email_id = resultSet.getString("email_id");
				String password = resultSet.getString("password");
				
				customer = new Customer(firstname,lastname, email_id, password);
			}
		}
		return customer;
		
	}

}
