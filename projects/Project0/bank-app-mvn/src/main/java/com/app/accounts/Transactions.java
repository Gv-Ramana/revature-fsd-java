package com.app.accounts;

public class Transactions {
	
	private int customerId;
	private String name;
	private String accountNumber;
	private double initialAmount;
	private int accountId;
	private char type;
	private double amount;

	public Transactions(char type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public Transactions() {
		
	}
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getInitialAmount() {
		return initialAmount;
	}

	public void setInitialAmount(double initialAmount) {
		this.initialAmount = initialAmount;
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
		return "CustomerId: " + customerId + "  Name: " + name + "  Account Number: " + accountNumber
				+ "  Balance: " + initialAmount + "  Account Id: " + accountId + "  Type: " + type + "  Amount: "
				+ amount;
	}



}
