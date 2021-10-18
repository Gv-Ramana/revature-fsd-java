package com.app.menu;

import java.sql.SQLException;
import java.util.List;

import com. app.accounts.Account;
import com. app.accounts.PendingAccounts;
import com. app.accounts.Transactions;
import com. app.dao.EmployeeDao;
import com. app.dao.impl.EmployeeDaoImpl;
import com. app.form.CreateAccount;
import com. app.form.LoginForm;
import com. app.form.SignUpForm;
import com. app.model.Customer;

public class EmployeeMenu extends Menu{

	public EmployeeMenu(String name) {
		super(name);
		addMenuItems("Register for Customer account");
		addMenuItems("View Customers");
		addMenuItems("View Accounts");
		addMenuItems("View Transactions");
		addMenuItems("Pending Accounts");
		addMenuItems("Logout");
		
	}

	@Override
	void handleAction() {
		EmployeeDao edao = new EmployeeDaoImpl();
		switch(choice) {
		
		case 1:
			SignUpForm signUp = new SignUpForm("Customer SignUp");
			signUp.captureDataAndPerformAction();
			
			LoginForm loginForm = new LoginForm("Customer Login");
			loginForm.captureDataAndPerformAction();
			
			CreateAccount createAcc = new CreateAccount("Account details");
			createAcc.captureDataAndPerformAction();
			
			displayMenuAndSelectOption();
			
			break;
		case 2:
			try {
				List<Customer> list = edao.viewCustomer();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenu();
			break;
		case 3:
			try {
				List<Account> list = edao.viewAccount();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenu();
			break;
		case 4:
			try {
				List<Transactions> list = edao.viewTransaction();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenu();
			break;
			
		case 5:
			PendingAccounts pa = new PendingAccounts();
			pa.viewPending();
			displayMenu();
			break;
			
		case 6:
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenu();
			break;
		}
		
	}

}
