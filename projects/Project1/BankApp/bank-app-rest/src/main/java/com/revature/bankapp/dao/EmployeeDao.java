package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;


public interface EmployeeDao<Customer> {
	
	 List<Customer> viewCustomer() throws SQLException;
	

}
