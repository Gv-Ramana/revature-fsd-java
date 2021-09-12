package com.revature.BankApp.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	private static List<Customer> customerList = new ArrayList<>();
	
	static {
		customerList.add(new Customer("Jhon","Smith","john","123"))
	}
	
	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public static Customer getCustomerByEmailId(String emailId) {
		for(Customer customer:customerList) {
			if(customer.getEmailId().equals(emailId)) {
				return customer;
		    }
	    }
		return null;
	}
}

