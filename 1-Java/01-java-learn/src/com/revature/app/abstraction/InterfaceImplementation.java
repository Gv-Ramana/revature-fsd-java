package com.revature.app.abstraction;

public class InterfaceImplementation implements Interface {

	@Override
	public void abstractMethod() {
		
	}
	
	public static void main(String[] args) {
		Interface interface1 = new InterfaceImplementation();
		interface1.abstractMethod();
		
		//Interface interface2 = new Interface();
	}

}
