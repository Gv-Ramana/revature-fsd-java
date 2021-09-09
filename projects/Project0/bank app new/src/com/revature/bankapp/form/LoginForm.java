package com.revature.bankapp.form;

import java.util.Scanner;

import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class LoginForm extends Form {
	private String email;
	private String password;

	public LoginForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Email: ");
		email = scanner.nextLine();
		
		System.out.print("Password: ");
		password = scanner.nextLine();
	}

	@Override
	public void action() {
		Customer customer = DataManager.getCustomerByEmail(email);
		if (customer == null) {
			System.out.println("Invalid email / password");
		} else if (customer.getPassword().equals(password)) {
			success = true;
			System.out.println("Login Successful.");
			CustomerMainMenu menu = new CustomerMainMenu("Customer Main Menu");
			menu.displayMenuAndCaptureSelection();
			System.out.println("Welcome " + customer.getFirstName());
		} else {
			System.out.println("Invalid email / password");
		}
	}

}
