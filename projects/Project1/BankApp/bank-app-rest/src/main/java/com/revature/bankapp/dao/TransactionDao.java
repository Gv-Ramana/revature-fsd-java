package com.revature.bankapp.dao;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	void performWithdrawl(int accountId, double money) throws AppException;
	void performDeposit(long accountId, double money) throws AppException;
	long showBalance(long accounId) throws AppException;
	void addTransaction(int accountId, String type, double money) throws AppException;
	List<Transaction>showTransactions(long accountId) throws AppException;
}