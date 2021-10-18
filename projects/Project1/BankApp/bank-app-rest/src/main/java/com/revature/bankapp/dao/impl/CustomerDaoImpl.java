package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;
  
public class CustomerDaoImpl implements CustomerDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);


	
	public static int currentCustomerId;

	@Override
	public int create(Customer customer) throws AppException {
		LOGGER.info("Start");
		LOGGER.debug("{}",customer);
		try (Connection connection = Util.getConnection()) {
	
			String sql = "insert into customer(First_Name,Last_Name, Email,Password,PhoneNumber) values (?, ?, ?, ?,?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.setString(5, customer.getPhoneNumber());
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}catch(SQLException e) {
			LOGGER.error("error create in customer",e);
			throw new AppException(e);
		}
	}
	
	public Customer getCustomerEmail(String Email) throws SQLException {
		Customer customer = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from customer where Email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,  Email);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentCustomerId = resultSet.getInt("id");
				String FirstName = resultSet.getString("First_Name");
				String LastName = resultSet.getString("Last_Name");
				String email = resultSet.getString("Email");
				String Password = resultSet.getString("Password");
				String phoneNumber = resultSet.getString("PhoneNumber");
				
				customer = new Customer(currentCustomerId,FirstName, LastName ,email,Password,phoneNumber);
			}
		}
		return customer;
		
	}
	public Customer getCurrentCustomer() throws SQLException {
		Customer customer = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from customer where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,  currentCustomerId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String FirstName = resultSet.getString("First_Name");
				String LastName = resultSet.getString("Last_Name");
				String email = resultSet.getString("Email");
				String Password = resultSet.getString("Password");
				String phoneNumber = resultSet.getString("PhoneNumber");
				customer = new Customer( id,FirstName, LastName ,email,Password,phoneNumber);
			}
		}
		return customer;
		
	}
}


