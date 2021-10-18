package com.revature.app.accessmodifier;

public class AnotherClass {

	public static void main(String[] args) {
		PackageDemo demo = new PackageDemo();
		// demo.age is visible as it is from the same package
		System.out.println(demo.age);
	}
}
