package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	public static List<Customer> customerList = new ArrayList<Customer>();

	public static Customer currentCustomer;

	public static void addCustomer(Customer customer) {

		customerList.add(customer);
	}

	public static Customer getCustomerUserId(String userId) {

		for (Customer customer : customerList) {
			if (customer.getUserId().equals(userId)) {
				return customer;
			}
		}
		return null;
	}

	public static void setcurrentCustomer(Customer customer) {
		currentCustomer = customer;
	}

	public static Customer currentCustomer() {
		return currentCustomer;
	}

	

}
