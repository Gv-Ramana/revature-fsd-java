package com.revature.BankApp.menu;

import java.util.Scanner;

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
	public void handleAction() {
		System.out.println("Selected option is "+ selection);
		Scanner scan = new Scanner(System.in);
		switch(selection) {
		case 1:
			System.out.println("======");
			System.out.println("Register for new customer");
			System.out.println("======\n");
			
			System.out.print("Enter Firstname : ");
			String firstName = scan.nextLine();
			
			System.out.print("Enter lastname : ");
			String lastName = scan.nextLine();
			
			System.out.print("Enter EmailId : ");
			String emailId = scan.nextLine();
			
			System.out.print("Enter Password : ");
			String password = scan.nextLine();
			
			DataManager.addCustomer(new Customer(firstName,lastName,emailId,password));
			System.out.print("Customer Registered Successfully");
			displayMenuAndCaptureSelection();
			break;
		case 2:
			 LoginForm loginform = new LoginForm("Login Form");
			 loginform.captureDataAndPerformAction();
			 break;
			
		case 3:
			System.out.println("Login as Employee");
			break;
		case 4:
			System.out.println("Exit");
		}
	}
	
}

