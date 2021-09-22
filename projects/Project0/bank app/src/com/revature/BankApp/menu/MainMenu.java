package com.revature.BankApp.menu;
import java.util.Scanner;
import com.revature.BankApp.form.CustomerRgistrationForm;
import com.revature.BankApp.form.LoginForm;
import com.revature.BankApp.model.Customer;
import com.revature.BankApp.model.DataManager;

public class MainMenu extends Menu{
	
	public MainMenu(String name) {
		super(name);
		
		 addMenuItem("Register for new customer");
		 addMenuItem("Login as aCustomer");
		 addMenuItem("Login as Employee");
		 addMenuItem("Exit");
		  
	}
	void handleAction() {
		Scanner scanner = new Scanner(System.in);
		switch (selection) {
		case 1:
			CustomerRgistrationForm customerRegistrationForm = new CustomerRgistrationForm("Customer Registration Form");
			customerRegistrationForm.captureDataAndPerformAction();
			displayMenuAndCaptureSelection();
			break;
		case 2 :
			LoginForm loginForm = new LoginForm("Customer registration form");
			loginForm.captureDataAndPerformAction();
			displayMenuAndCaptureSelection();
			break;
		case 3 :
			System.out.println("Welcome Back!!!");
			break;
		case 4 : 
			System.out.println("Closing The Application");
			break;

		}
	}
	
}

