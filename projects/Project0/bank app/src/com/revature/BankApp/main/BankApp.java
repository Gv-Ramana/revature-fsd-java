package com.revature.BankApp.main;

import com.revature.BankApp.menu.MainMenu;

public class BankApp {

	public static void main(String[] args) {
		 
		MainMenu menu = new MainMenu("MainMenu");
		menu.displayMenuAndCaptureSelection();
				 
	}

}
