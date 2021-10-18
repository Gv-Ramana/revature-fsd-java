package com.app.form;

import java.sql.SQLException;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.dao.EmployeeDao;
import com.app.dao.Util;
import com.app.dao.impl.EmployeeDaoImpl;
import com.app.menu.EmployeeMenu;
import com.app.model.Employee;

public class EmployeeLogin extends Form {
	
	private String employeeId;
	private String password;
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

	public EmployeeLogin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		LOGGER.info("Employee UserId: ");
		employeeId  = sc.nextLine();
		
		LOGGER.info("Password: ");
		password = sc.nextLine();
		
	}

	@Override
	public void action() {
		EmployeeDaoImpl edao = new EmployeeDaoImpl();
		try {
			Employee employee = edao.getEmployeeUserId(employeeId);
			if (employee == null) {
				LOGGER.info("Invalid Username or Passworrd");
			} 
			else if (employee.getPassword().equals(password)){
				success = true;
				LOGGER.info("Login Successfull\n");
				LOGGER.info("Welcome " + employee.getName());
				EmployeeMenu empMenu = new EmployeeMenu("Admin Options");
				empMenu.displayMenuAndSelectOption();
			} else {
			LOGGER.info("Invalid Username or Password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			  LOGGER.info("*********** FAILED*************");
		}
		
	}

}
