package com.lombok.builder;

public class TestUser {

	public static void main(String[] args) {
	
	User u1 =	User.builder()
					.name("Tom")
					.age(26)
					.build();
	
	
	User u2 = User.builder().name("Lakshay").build();
	
	User u3 = User.builder().build();
	
	System.out.println(u1.getName() +" " + u1.getAge());
	System.out.println(u2.getName() + " " + u2.getAge());
	System.out.println(u3.getName() + " " + u3.getAge());//
	
	
	
	
	//we are using builder at costructor level so we can only build values for those we take as parameters in constructor
	Person p1 = Person.builder().name("Raju").marks(123).build();
	
	System.out.println(p1.getName()+ " " + p1.marks + " " + p1.getRole() + " " + p1.isActive);
	
	
	//Creating on method level
	
	BuilderMethodLevel b1 = BuilderMethodLevel.builder().name("Shital").age(29).build();
	
	System.out.println(b1.getName()+ " " + b1.getAge() + " " + b1.getCity() + " " + b1.isActive);
	
	
	
	}

}
