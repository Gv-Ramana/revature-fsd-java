package com.revature.BankApp.form;
import java.util.Scanner;
import com.revature.BankApp.menu.MainMenu;
import com.revature.BankApp.model.Customer;
import com.revature.BankApp.model.DataManager;

  public class CustomerRgistrationForm extends Form{

	public CustomerRgistrationForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter First Name:");
		String firstName = scanner.nextLine();
		System.out.print("Enter LastName:");
		String lastName = scanner.nextLine();
		System.out.print("Enter emailId:");
		String email = scanner.nextLine();
		System.out.print("Setup password:");
		String password = scanner.nextLine();
		
		
		
		DataManager.addCustomer(new Customer(firstName, lastName, email, password,Customer.createAccountList()));
		
	}

	@Override
	public void action() {
		success =true;
		
	}

}