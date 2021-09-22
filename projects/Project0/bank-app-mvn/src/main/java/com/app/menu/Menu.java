package com.app.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
	//instance values that are used in main menu and customer menu
	protected String menuName;
	protected List<String> menuItemsList;
	protected int choice;
	//instantiation of menu name and array list that holds menu items
	public Menu(String menuName){
		this.menuName = menuName;
		this.menuItemsList =  new ArrayList<>();
	}
	//add menu items
	public void addMenuItems(String menuItems) {
		 
		menuItemsList.add(menuItems);
		
	}
	//method to display menu items
	public void displayMenu() {
		//for loop that iterate through menu items and display one by one
		 for(int i = 0;i<menuItemsList.size();i++) {
			 System.out.println(i+1 + ")" + menuItemsList.get(i));
		 }
	}
	//method taking option in switch case to display required menu item
	public void selectNumber( ) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a option");
		choice = scan.nextInt();
	}
	public void displayMenuAndSelectOption()
	{
		System.out.println("**WELCOME USER**");
		displayMenu();
		boolean selected_number = false;
		while(!selected_number) {
			try {
				selectNumber();
				 
				if(choice>0 && choice<=menuItemsList.size()) {
					selected_number = true;
				}else 
					System.out.println("select numbers from 1 - "+menuItemsList.size() );
			}catch(Exception e) {
				System.out.println("Invalid entry");
			}
		}
		handleAction();
	}
    abstract void handleAction();
	
}