package com.revature.BankApp.form;
import java.util.Scanner;

import com.revature.BankApp.menu.CustomerMainMenu;
import com.revature.BankApp.model.Customer;
import com.revature.BankApp.model.DataManager;

public class LoginForm extends Form {
	private String emailId;
	private String password;

	public LoginForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print(" EmailId : ");
		emailId = scan.nextLine();
		
		System.out.print(" Password : ");
		password = scan.nextLine();
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Customer customer = DataManager.getCustomerByEmail(emailId);
		if (customer== null) {
		       System.out.println("Invalid email / password");
		    } else if(customer.getPassword().equals(password)) {
		    	success = true;
		    	System.out.println("Login Successfull");
		    	CustomerMainMenu menu = new CustomerMainMenu("Customer Main Menu");
		    	menu.displayMenuAndCaptureSelection();
		        System.out.println("Welcome " + customer.getFirstName());
		    } else {
		    	System.out.println("Invalid email / password");
		    }
		 	
	

}}
