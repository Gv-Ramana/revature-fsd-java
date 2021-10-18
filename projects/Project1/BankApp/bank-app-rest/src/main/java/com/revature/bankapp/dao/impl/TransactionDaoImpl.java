package com.revature.bankapp.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;
import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;

public class TransactionDaoImpl implements TransactionDao {
	//AccountDaoImpl accdao = new AccountDaoImpl();

	public void update(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getBalance());
			statement.setInt(2, AccountDaoImpl.currentAccountId);
			statement.executeUpdate();
		}

	}

	public void insert(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, accountid) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, AccountDaoImpl.currentAccountId);
			statement.executeUpdate();
		}

	}

	public static List<Transaction> transactionList() throws SQLException {
		List<Transaction> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from transaction where accountId = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, AccountDaoImpl.currentAccountId);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transaction trans = new Transaction();
				trans.setType(resultSet.getString("type").charAt(0));
				trans.setAmount(resultSet.getDouble("amount"));
				transactionList.add(trans);

			}

			return transactionList;

		}

	}

	@Override
	public void performWithdrawl(int accountId, double money) throws AppException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performDeposit(long accountId, double money) throws AppException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long showBalance(long accounId) throws AppException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTransaction(int accountId, String type, double money) throws AppException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transaction> showTransactions(long accountId) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}
}
