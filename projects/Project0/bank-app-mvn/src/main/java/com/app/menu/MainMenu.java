package com.app.menu;
import com.app.form.LoginForm;
import com.app.form.SignUpForm;
 
 

public class MainMenu extends Menu{
	public MainMenu(String menuName) {
		super(menuName);
		addMenuItems("Register as new Customer");
		addMenuItems("Customer  Login");
		addMenuItems("Employee Login");
		addMenuItems("Exit");	
	}
	public void handleAction()
	{
		System.out.println("Selected Option is: " + choice);
		switch(choice) {			
		case 1:
			SignUpForm signUp = new SignUpForm("Customer SignUp");
			signUp.captureDataAndPerformAction();
			MainMenu mainMenu = new MainMenu("Main Menu");
			mainMenu.displayMenuAndSelectOption();
			break;
		case 2:
			 
			LoginForm loginForm = new LoginForm("Customer Login");
			loginForm.captureDataAndPerformAction();
			CustomerMainMenu customerMenu = new CustomerMainMenu("Customer Menu");
			customerMenu.displayMenuAndSelectOption();
			break;
		case 3:
			System.out.println("login as employee");
			break;
		case 4:
			System.out.println("Thank you for using our services");
			break;
			
		}
	 
	 
}
}
