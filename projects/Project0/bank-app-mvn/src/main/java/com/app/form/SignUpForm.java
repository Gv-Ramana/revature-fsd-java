package com.app.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.CustomerDao;
import com.app.dao.impl.CustomerDaoImpl;
import com.app.model.Customer;

public class SignUpForm extends Form{
	public SignUpForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private String firstname;
	private String lastname;
	private String userId;
	private String password;

	 
	@Override
	public void captureData() {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("firstname : ");
		firstname = sc.nextLine();
		
		System.out.println("lastname : ");
		lastname = sc.nextLine();
		System.out.println("UserId : ");
		userId = sc.nextLine();

		System.out.println("Password : ");
		password = sc.nextLine();
		
	}

	@Override
	public void action() {
		
		CustomerDao dao = new CustomerDaoImpl();
		try {
			dao.create(new Customer(firstname,lastname, userId, password));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot create customer");
		}
		System.out.println("Registeration succesfully");
		success = true;
		
	}

}
