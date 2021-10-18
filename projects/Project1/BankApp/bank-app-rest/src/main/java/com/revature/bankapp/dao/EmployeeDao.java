package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;


public interface EmployeeDao<Customer> {
	
	public List<Customer>  showCustomerList() throws AppException;
	public List<Transaction> showTransList(long accountId) throws AppException;
	List<Account> getAccountsToVerify() throws SQLException;
	void approveAccount( long accountId) throws SQLException;
	void rejectAccount(long accountId) throws SQLException;
	
	

}
