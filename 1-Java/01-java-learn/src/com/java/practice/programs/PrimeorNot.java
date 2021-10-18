package com.java.practice.programs;

import java.util.Scanner;

public class PrimeorNot {
	public static String display(int num) {
		int count=0;
			for(int i=1;i<=num/2;i++) {
				if(num%i == 0) {
					count++;	
				}}
			if(count==1)  
				return "Prime";
			 else 
				return "Not Prime"; 
			
			 	
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a Number");
		int number = scan.nextInt();
		String result=display(number);
		System.out.println(number+" is "+result);
		
	}
		
	}
		
	
	

