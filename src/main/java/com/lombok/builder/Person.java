package com.lombok.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Person {

	String name;
	int marks;
	boolean isActive;
	String role;
	
	@Builder()
	public Person(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	
}
