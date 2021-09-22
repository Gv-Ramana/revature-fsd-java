package com.app.menu;
import java.sql.SQLException;
import com.app.accounts.DisplayAccountAndTransaction;
import com.app.dao.impl.AccountDaoImpl;
import com.app.form.CreateAccount;

public class CustomerMainMenu extends Menu {

	AccountDaoImpl accdao = new AccountDaoImpl();

	public CustomerMainMenu(String name) {
		super(name);
		addMenuItems("Open New Account");
		addMenuItems("View Accounts");
		addMenuItems("Transactions");
		addMenuItems("Back to main menu");
		addMenuItems("Exit");

	}

	@Override
	void handleAction() {
		switch (choice) {

		case 1:

			CreateAccount createAcc = new CreateAccount("Account details");
			createAcc.captureDataAndPerformAction();
			CustomerMainMenu customerMenu = new CustomerMainMenu("Customer Menu");
			customerMenu.displayMenuAndSelectOption();
			break;

		case 2:
			DisplayAccountAndTransaction.accountsList();
			break;
			
		case 3:
			
			WithdrawAndDeposit wd = new WithdrawAndDeposit("Transaction Menu");
			String temp = wd.getAccount();
			try {
				if (accdao.validAccount(temp).getApproved() == 'Y') {
					wd.displayMenuAndSelectOption();
				} else {
					System.out.println("Account Not Approved");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			break;

		case 4:
			MainMenu mainMenu = new MainMenu("Main Menu");
			mainMenu.displayMenuAndSelectOption();
			break;
			
		case 5:
			System.out.println("Thank you Visit again");
			break;
		}
	}
}
