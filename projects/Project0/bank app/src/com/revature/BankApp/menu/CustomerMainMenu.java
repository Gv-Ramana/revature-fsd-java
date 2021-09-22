package com.revature.BankApp.menu;
import java.util.Scanner;
import com.revature.BankApp.form.AccountRegistrationForm;

import com.revature.BankApp.model.*;
 
public class CustomerMainMenu extends Menu {

	public CustomerMainMenu(String name) {
		super(name);

		addMenuItem("Create new Account");
		addMenuItem("View Accounts");
		addMenuItem("Logout");

		displayMenuAndCaptureSelection();
	}

	@Override
	void handleAction() {
		Scanner scanner = new Scanner(System.in);
		switch (selection) {
		case 1:
			AccountRegistrationForm accountRegistrationForm = new AccountRegistrationForm("New Account registartion form");
			accountRegistrationForm.captureDataAndPerformAction();
			displayMenuAndCaptureSelection();
			break;
		case 2:
			System.out.println("These are Your Accounts");
			System.out.println(Customer.getAccountList());
			Customer.selectAccount();
			TransactionMenu transactionMenu = new TransactionMenu("Transactrion Menu");
			transactionMenu.displayMenuAndCaptureSelection();
			break;
		case 3:
			System.out.println("Logout");
			break;
		}

	}

}
