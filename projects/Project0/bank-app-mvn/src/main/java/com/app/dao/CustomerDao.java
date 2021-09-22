package com.app.dao;

import java.sql.SQLException;

import com.app.model.Customer;

public interface CustomerDao {

	Customer get(int id) throws SQLException;

	void create(Customer customer) throws SQLException;

	void update(Customer customer) throws SQLException;

	void delete(int id) throws SQLException;

}
