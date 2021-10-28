package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;
import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	public Employee getEmployeeUserName(String userName) throws SQLException {
		Employee employee = null;

		try (Connection connection = Util.getConnection()) {
			String sql = "select * from admin where userName = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String username = resultSet.getString("userName");
				String password = resultSet.getString("password");

				employee = new Employee(name, username, password);
			}
		}
		return employee;
	}

	public List<Customer> viewCustomer() throws SQLException {
		List<Customer> customerList = new ArrayList<>();

		try (Connection connection = Util.getConnection()) {
			String sql = "select * from customer";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Customer customerTemp = new Customer();
				customerTemp.setFirstName(resultSet.getString("First_Name"));
				customerTemp.setLastName(resultSet.getString("Last_Name"));
				customerTemp.setEmail(resultSet.getString("Email"));
				customerTemp.setPhoneNumber(resultSet.getString("PhoneNumber"));

				customerList.add(customerTemp);

			}
			return customerList;
		}

	}

	public static List eViewAccount() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select c.id, c.First_Name,c.Last_name,c.Email,c.Phonenumber,a.customerid, accountnumber, balance from account a\r\n"
					+ " inner join customer c on customerid = c.id;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Account accountTemp = new Account();
				accountTemp.setCustomerId(resultSet.getInt("customerid"));
				accountTemp.setId(resultSet.getInt("id"));
				accountTemp.setFirst_Name(resultSet.getString("First_Name"));
				accountTemp.setLast_Name(resultSet.getString("Last_Name"));
				accountTemp.setEmail(resultSet.getString("Email"));
				accountTemp.setAccountNumber(resultSet.getString("accountnumber"));
				accountTemp.setBalance(resultSet.getDouble("balance"));

				accountList.add(accountTemp);

			}
		}
		return accountList;

	}

	public static List<Transaction> eViewTransaction() throws SQLException {
		List<Transaction> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql ="select c.id, c.First_Name, c.Last_Name, c.Email,c.PhoneNumber,a.accountnumber, a.balance, t.type , t.amount ,t.accountId \r\n" + 
					"from transaction t\r\n" + 
					"inner join account a \r\n" + 
					"on accountId = a.id \r\n" + 
					"inner join customer c\r\n" + 
					" on customerid = c.id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();	
			while (resultSet.next()) {
				Transaction transactionTemp = new Transaction();
				transactionTemp.setAccountId(resultSet.getInt("accountId"));
				transactionTemp.setCustomerId(resultSet.getInt("id"));
				transactionTemp.setFirstName(resultSet.getString("First_Name"));
				transactionTemp.setLastName(resultSet.getString("Last_Name"));
				transactionTemp.setAccountNumber(resultSet.getString("accountnumber"));
				transactionTemp.setBalance(resultSet.getDouble("balance"));
				transactionTemp.setType(resultSet.getString("type").charAt(0));
				transactionTemp.setAmount(resultSet.getDouble("amount"));
				transactionList.add(transactionTemp);

			}
		}
		return transactionList;

	}

	public List showCustomerList() throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	public List showTransList(long accountId) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAccountsToVerify() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void approveAccount(long accountId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void rejectAccount(long accountId) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
