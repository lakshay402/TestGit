package com.lombokJar.examples;

public class CheckTestLombookClass {

	public static void main(String[] args) {
		
		
		TestLombok test = new TestLombok();
		TestLombok test2 = new TestLombok("Lokesh", "lakshay2324@gmail.com", "Adarsh Colony", 21, false);
		
		System.out.println(test2);
		test2.setActive(true);
		System.out.println(test2.isActive());
		
		test.setName("Lakshay");
		test.setActive(true);
		
		System.out.println(test.toString());
		System.out.println(test.getName()+" "+test.isActive());

	}

}
