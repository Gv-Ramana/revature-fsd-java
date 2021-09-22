package com.app.accounts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.impl.AccountDaoImpl;
import com.app.menu.CustomerMainMenu;

public class DisplayAccountAndTransaction {

	public static ArrayList<Account> accountsList() {

		AccountDaoImpl accdao = new AccountDaoImpl();
		try {
			List<Account> accounts = accdao.accountList();
			for (int i = 0; i < accounts.size(); i++) {
				System.out.println((i + 1) + ") " + accounts.get(i).print());
			}
			CustomerMainMenu cm = new CustomerMainMenu("Customer Menu");
			cm.displayMenuAndSelectOption();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot display accounts");
		}
		return null;
	}

	public static ArrayList<Transactions> transactionsList() {

		AccountDaoImpl accdao = new AccountDaoImpl();
		try {
			List<Transactions> transaction = accdao.transactionList();
			for (int i = 0; i < transaction.size(); i++) {
				System.out.println((i + 1) + ") " + transaction.get(i).print());
			}
			CustomerMainMenu cm = new CustomerMainMenu("Customer Menu");
			
			cm.displayMenuAndSelectOption();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot display accounts");
		}
		return null;
	}
}
