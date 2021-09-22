package com.revature.BankApp.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String passowrd;
	private static long counter = 0;
	private static ArrayList<Account> accountList;
	private static int choice;
	private static int balance;

	public Customer(String firstName, String lastName, String email, String passowrd, ArrayList<Account> accountList) {
		super();
		counter++;
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passowrd = passowrd;
		this.accountList = accountList;
	}

	public static void addAccount(Account account) {
		DataManager.getCurrentCustomer().getAccountList().add(account);
	}

	public static ArrayList<Account> getAccountList() {
		return DataManager.getCurrentCustomer().accountList;
	}

	public static void setAccountList(ArrayList<Account> accountList) {
		Customer.accountList = accountList;
	}

	public String getPassword() {
		return passowrd;
	}

	public void setPassword(String passowrd) {
		this.passowrd = passowrd;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public static void selectAccount() {
		System.out.print("Select account to perform transaction : ");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		if (choice <= 0 && choice > DataManager.getCurrentCustomer().getAccountList().size()) {
			System.out.println("Choose valid Account");
			selectAccount();
		}

	}

	public static void displayWithdraw() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter  withdrawl amount:");
		int with = scanner.nextInt();

		if (balance > with) {
			balance = (balance - with);
			System.out.println("Please Collect your " + with + " Rupees");
			System.out.println(" ");
			System.out.println("Total Balance: " + balance);
			System.out.println(" ");
		}
	}

	public static void getAccountDetails() {
		Customer customer = DataManager.getCurrentCustomer();
		customer.getAccountList();
	}

	public static void getAccountBalance() {
		System.out.println("Balance :" +  DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance());
	}

	public static int depoist() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the amount to be depoisted:");
		int depoistAmount = scanner.nextInt();
		if (depoistAmount <= 0) {
			System.out.println("valid  amount to be depoisted:");

		} else {
			return depoistAmount;
		}
		return depoistAmount;
	}

	public static ArrayList<Account> createAccountList() {
		ArrayList<Account> list = new ArrayList<>();
		return list;
	}

	public static void displayDepoist() {

	}
}


















































/*package com.revature.BankApp.model;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String passowrd;
	private static long counter = 0;
	private static ArrayList<Account> accountList;
	private static int choice;

	public Customer(String firstName, String lastName, String email, String passowrd, ArrayList<Account> accountList) {
		super();
		counter++;
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passowrd = passowrd;
		this.accountList = accountList;
	}

	public static void addAccount(Account account) {
		DataManager.getCurrentCustomer().getAccountList().add(account);
	}

	public static ArrayList<Account> getAccountList() {
		return DataManager.getCurrentCustomer().accountList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		Customer.accountList = accountList;
	}

	public String getPassword() {
		return passowrd;
	}

	public void setPassword(String passowrd) {
		this.passowrd = passowrd;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public static void selectAccount() {
		System.out.print("Select account to perform transaction : ");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		if (choice <= 0 && choice > DataManager.getCurrentCustomer().getAccountList().size()) {
			System.out.println("Choose valid Account");
			selectAccount();
		}

		// performTransaction();
	}

	public static void withdrawl() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter amount to withdraw : ");
		long withdrwalAmount = scanner.nextLong();
		if (withdrwalAmount <= 0) {
			System.out.println("You cannot withdraw negative amount");
		} else if (DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance() >= withdrwalAmount) {
			DataManager.getCurrentCustomer().getAccountList().get(choice).setBalance(
					DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance() - withdrwalAmount);
			System.out.println(
					" Balance : " + DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance());
		} else {
			System.out.println("Insuuficient Funds");
			System.out.println(
					" Balance : " + DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance());
		}
	}

//	public static void getAccountDetails() {
//		Customer cus = DataManager.getCurrentCustomer();
//		cus.getAccountList();
//	}

	public static void getAccountBalance() {
		System.out.println("Balance :" + DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance());
	}

	public static void deposit() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter amount to deposit: ");
		long depositAmount = scanner.nextLong();
		DataManager.getCurrentCustomer().getAccountList().get(choice)
				.setBalance(DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance() + depositAmount);
		System.out.println("Balance :" + DataManager.getCurrentCustomer().getAccountList().get(choice).getBalance());

	}

	public static ArrayList<Account> createAccountList() {
		ArrayList<Account> list = new ArrayList<>();
		return list;
	}

}
*/