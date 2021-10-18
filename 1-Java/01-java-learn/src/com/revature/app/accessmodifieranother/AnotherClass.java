package com.revature.app.accessmodifieranother;

import com.revature.app.accessmodifier.PackageDemo;

public class AnotherClass {
	public static void main(String[] args) {
		PackageDemo demo = new PackageDemo();
		// demo.age is not visible in another package.
		//System.out.println(demo.age);
	}
}
