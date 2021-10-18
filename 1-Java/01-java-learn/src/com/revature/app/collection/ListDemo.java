package com.revature.app.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ListDemo {

	public static void main(String[] args) {
		//Integer age = new Integer(10);
		Integer age = 10; // auto boxing
		// short, boolean, character .....
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(78);
		arrayList.add(90);
		arrayList.add(34);
		arrayList.add(32);
		arrayList.add(58);
		arrayList.add(21);
		
		for (int number : arrayList) {
			System.out.println(number);
		}
		arrayList.set(1, 95);
		System.out.println("\nUsing index");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

		System.out.println("\nSorted");
		Collections.sort(arrayList);
		for (Integer number : arrayList) {
			System.out.println(number);
		}
	}

}
