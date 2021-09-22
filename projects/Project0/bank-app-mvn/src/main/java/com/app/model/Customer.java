package com.app.model;
import java.util.ArrayList;
import com.app.accounts.*;
import java.util.List;
import java.util.Scanner;

import com.app.accounts.Account;
public class Customer {
 	
//	}
//	public String getEmail() {
//		return email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public static void loginAsACustomer()
//	{
//		System.out.println("Enter email : ");
//		Scanner input = new Scanner(System.in);
//		String inputEmail = input.nextLine();
//		System.out.println("Enter password : ");
//		String inputPassword = input.nextLine();
//		if(inputEmail.equals(email) && inputPassword.equals(password))
//		{
//			System.out.println("login successfull");
//		}
//		else {
//			System.out.println("invalid Email/password");
//		    loginAsACustomer();
//		}
//		System.out.println("register for a new Bank Account \n");
//		
//		Account ac = new Account();
//		System.out.println(ac);
//		//ac.getAccountDetails();
//	} 
//	
	private int customerId;
	private String name;
	private String userId;
	private String password;
	private ArrayList<Account> accountList;
	private String firstname;
	private String lastname;
    
	public Customer(String firstname,String lastname,String userId,String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.userId = userId;
		this.password = password;
	}


	public Customer(String name, String userId, String password, ArrayList<Account> accountList) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.accountList = accountList;
	}
	
	

	public Customer(String name, String userId, String password) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
	}
	
	public Customer() {
		
	}



	public String getfirstname() {
		return firstname;
	}


	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getlastname() {
		return lastname;
	}


	public void setlastname(String lastname) {
		this.lastname = lastname;
	}


	public ArrayList<Account> getAccountList() {
		return accountList;
	}


	public long getId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}
	
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	public static void addAccount(Account account) {
		DataManager.currentCustomer().getAccountList().add(account);
	}

	@Override
	public String toString() {
		return "CustomerId: " + customerId + "  Name: " + name + "  UserId=" + userId;
	}

}
