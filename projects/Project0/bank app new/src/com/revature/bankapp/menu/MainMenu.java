package com.revature.bankapp.menu;

public class MainMenu extends Menu {
	public MainMenu(String name) {
		super(name);
		addMenuItem("Register new Customer");
		addMenuItem("Login as Customer");
		addMenuItem("Login as Employee");
		addMenuItem("Exit");
		
	}

	@Override
	void handleAction() {
		System.out.println("Selected option is:" + selection);
		
	}

}
