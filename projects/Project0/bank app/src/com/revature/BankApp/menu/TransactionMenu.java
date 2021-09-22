package com.revature.BankApp.menu;

import com.revature.BankApp.model.Customer;
//import com.revature.BankApp.model.DataManager;

public class TransactionMenu extends Menu {

	public TransactionMenu(String name) {
		super(name);
		addMenuItem("Withdraw");
		addMenuItem("Deposit");
		addMenuItem("View Balance");
		addMenuItem("View Transaction Log");
		addMenuItem("Back");
	}

	@Override
	void handleAction() {
		switch (selection) {
		case 1:
			System.out.println("withDraw granted");
			Customer.displayWithdraw();
			displayMenuAndCaptureSelection();
			break;
		case 2:
			System.out.println("Deposit Granted");
			Customer.displayDepoist();
			displayMenuAndCaptureSelection();
			break;
		case 3:
			System.out.println("View Balance");
			Customer.getAccountBalance();
			displayMenuAndCaptureSelection();
			break;
		case 4:
			System.out.println("View Transaction Log");
			break;
		case 5:
			break;
		}
	}

}










































/*package com.revature.BankApp.menu;

import com.revature.BankApp.model.Customer;
import com.revature.BankApp.model.DataManager;

public class TransactionMenu extends Menu {

	public TransactionMenu(String name) {
		super(name);
		addMenuItem("Withdrwal");
		addMenuItem("Deposit");
		addMenuItem("View Balance");
		addMenuItem("View Transaction Log");
		addMenuItem("Back");
	}

	@Override
	void handleAction() {
		switch (selection) {
		case 1:
			System.out.println("withDrawal granted");
			Customer.withdrawl();
			displayMenuAndCaptureSelection();
			break;
		case 2:
			System.out.println("Deposit Granted");
			Customer.deposit();
			displayMenuAndCaptureSelection();
			break;
		case 3:
			System.out.println("View Balance");
			Customer.getAccountBalance();
			displayMenuAndCaptureSelection();
			break;
		case 4:
			System.out.println("View Treansaction Log");
			break;
		case 5:
			break;
		}
	}

}*/
