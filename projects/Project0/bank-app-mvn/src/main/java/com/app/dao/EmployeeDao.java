package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.accounts.Account;
import com.app.accounts.Transactions;
import com.app.model.Customer;

public interface EmployeeDao {
	
	List<Customer> viewCustomer() throws SQLException;
	
	List<Account> viewAccount() throws SQLException;
	
	List<Transactions> viewTransaction() throws SQLException;

}