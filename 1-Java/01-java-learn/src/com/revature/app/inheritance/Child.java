package com.revature.app.inheritance;

public class Child extends Parent {
	
	// 'super' keyword in the child is used to
	// refer the parent class
	// 'super' is used to refer the immediate parent
	public Child(int age) {
		super(age);
	}
	
	public void childInstanceMethod() {
		super.instanceMethod();
		System.out.println("childInstanceMethod()");
		System.out.println(age);
	}
	
	// Method Overriding
	@Override
	public void instanceMethod() {
		//super.instanceMethod();
		System.out.println("Child instanceMethod()");
	}
	
	public static void staticMethod() {
		System.out.println("Child staticMethod()");
	}

	public static void main(String[] args) {
		Child child = new Child(10);
		child.instanceMethod();
		Child.staticMethod();
		//Parent.staticMethod();
		//child.childInstanceMethod();
		
		// Runtime Polymorphism
		Parent parent = new Child(20);
		parent.instanceMethod();
	}

}
