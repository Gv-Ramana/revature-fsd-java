package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transactions;

public class AccountDaoImpl implements AccountDao {

	public static int currentAccountId;
	public static int transferAccountId;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

	@Override
	public void create(Account account) throws AppException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into account (account_number, balance, customer_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, account.getAccountNumber());
			statement.setDouble(2, account.getBalance());
			statement.setInt(3, CustomerDaoImpl.currentCustomerId);
//			statement.setString(4, String.valueOf('N'));
			statement.executeUpdate();
			LOGGER.info("Account Created");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e);
		}

	}

	public List<Account> accountList() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, CustomerDaoImpl.currentCustomerId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setAccountId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getInt("account_number"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList.add(account);

			}
		}

		return accountList;

	}
	
	public Account currentAccount(int accNum) throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, accNum);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentAccountId = resultSet.getInt("id");
				int accNumber = resultSet.getInt("account_number");
				Double initialAmount = resultSet.getDouble("balance");

				account = new Account(accNumber, initialAmount);
			}
		}
		return account;
	}

	public void insert(Transactions transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, currentAccountId);
			statement.executeUpdate();

		}

	}

	public void insertTransfer(Transactions transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, transferAccountId);
			statement.executeUpdate();
		}
	}

	public void update(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getBalance());
			statement.setInt(2, currentAccountId);
			statement.executeUpdate();
		}
	}

	public List<Transactions> transactionList(int id) throws SQLException {
		List<Transactions> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from transaction where account_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transactions transaction = new Transactions();
				transaction.setType(resultSet.getString("type").charAt(0));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setAccountId(resultSet.getInt("account_id"));
				transactionList.add(transaction);
			}
		}
		return transactionList;
	}

	public void updateTransfer(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set initial_amount = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getBalance());
			statement.setInt(2, transferAccountId);
			statement.executeUpdate();
		}
	}

	public Account transferAccount() throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, TransactionMenu.transferAccNum);
			String transferAccNum = "";
			statement.setString(1, transferAccNum);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				transferAccountId = resultSet.getInt("id");
				int accNumber = resultSet.getInt("account_number");
				Double initialAmount = resultSet.getDouble("initial_Amount");

				account = new Account(accNumber, initialAmount);
			}
		}
		return account;
	}

	public void approveAccount(int tempId) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set approved = 'Y' where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, tempId);
			statement.executeUpdate();
		}

	}
	
	public void rejectAccount(int tempId) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "delete from account where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, tempId);
			statement.executeUpdate();
		}

	}
	
	public List<Account> pendingList() throws SQLException {
		List<Account> pendingList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where approved = 'N'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setAccountId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getInt("account_number"));
				account.setBalance(resultSet.getDouble("initial_amount"));
				pendingList.add(account);

			}
		}
		return pendingList;

	}
	
	public Account validAccount(String temp) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, temp);
			ResultSet resultSet = statement.executeQuery();
			Account account = new Account();
			while(resultSet.next()) {
				account.setApproved(resultSet.getString("approved").charAt(0));
			}
		return account;
		}
	}
}