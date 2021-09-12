package com.revature.BankApp.model;

public class Customer {
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	
	private static long counter = 0;
	public Customer(  String firstName, String lastName, String emailId, String password) {
		super();
		counter++;
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	 
	
	
}
