package com.revature.bankapp.model;

public class Transaction {

	private int customerId;
	private String firstName;
	private String lastName;
	private String accountNumber;	
	private double balance;
	private int accountId;
	private char type;
	private double amount;

	public Transaction(char type, double amount) {
		this.type = type;
		this.amount = amount;
	}

	
	public Transaction() {
		
	}
	

	public int getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String print() {
		return "Type: " + type + "  Amount: "+ amount;
	}

	@Override
	public String toString() {
		return "CustomerId: " + customerId + "  firstName: " + firstName + "  LastName: " +lastName + "  Account Number: " + accountNumber
				+ "  Balance: " + balance + "  Account Id: " + accountId + "  Type: " + type + "  Amount: "
				+ amount;
	}


	
	



}