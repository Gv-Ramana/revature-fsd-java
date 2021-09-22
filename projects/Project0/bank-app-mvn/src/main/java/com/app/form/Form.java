package com.app.form;

public abstract class Form {
	
	protected String name;
	protected boolean success;
	
	public Form(String name) {
		this.name = name;
		success = false;
	}
	private void displayTitle() {
		System.out.println("***" + name + "***");
	}

	public void captureDataAndPerformAction() {
		while (!success) {
			displayTitle();
			captureData();
			action();
		}
	}
	
	public abstract void captureData();
	
	public abstract void action();

}
	  
	
	


