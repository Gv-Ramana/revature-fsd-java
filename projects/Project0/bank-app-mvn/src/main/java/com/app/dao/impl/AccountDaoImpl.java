package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.accounts.Account;
import com.app.accounts.Transactions;
import com.app.dao.AccountDao;
import com.app.dao.Util;
import com.app.menu.WithdrawAndDeposit;

public class AccountDaoImpl implements AccountDao {

	public static int currentAccountId;
	public static int transferAccountId;

	public void create(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into account (account_number, initial_amount, customer_id, approved) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, account.getAccountNumber());
			statement.setDouble(2, account.getInitialAmount());
			statement.setInt(3, CustomerDaoImpl.currentCustomerId);
			statement.setString(4, String.valueOf('N'));
			statement.executeUpdate();
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
				account.setAccountNumber(resultSet.getString("account_number"));
				account.setInitialAmount(resultSet.getDouble("initial_amount"));
				accountList.add(account);

			}
		}

		return accountList;

	}

	public Account currentAccount() throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, WithdrawAndDeposit.accNumber);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentAccountId = resultSet.getInt("id");
				String accNumber = resultSet.getString("account_number");
				Double initialAmount = resultSet.getDouble("initial_Amount");

				account = new Account(accNumber, initialAmount);
			}
		}
		return account;
	}

	public static void insert(Transactions transaction) throws SQLException {
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
			String sql = "update account set initial_amount = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getInitialAmount());
			statement.setInt(2, currentAccountId);
			statement.executeUpdate();
		}
	}

	public List<Transactions> transactionList() throws SQLException {
		List<Transactions> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from transaction where account_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, currentAccountId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transactions transaction = new Transactions();
				transaction.setType(resultSet.getString("type").charAt(0));
				transaction.setAmount(resultSet.getDouble("amount"));
				transactionList.add(transaction);
			}
		}
		return transactionList;
	}

	public void updateTransfer(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set initial_amount = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getInitialAmount());
			statement.setInt(2, transferAccountId);
			statement.executeUpdate();
		}
	}

	public Account transferAccount() throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, WithdrawAndDeposit.transferAccNum);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				transferAccountId = resultSet.getInt("id");
				String accNumber = resultSet.getString("account_number");
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
				account.setId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getString("account_number"));
				account.setInitialAmount(resultSet.getDouble("initial_amount"));
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
