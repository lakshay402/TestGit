package com.lombok.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BuilderMethodLevel {

	String name;
	int age;
	boolean isActive;
	String city;
	
	
	public BuilderMethodLevel(String name, int age, boolean isActive, String city) {

		this.name = name;
		this.age = age;
		this.isActive = isActive;
		this.city = city;
	}
	
	@Builder
	public static BuilderMethodLevel createInstance(String name, int age) {
		
		return new BuilderMethodLevel(name, age, true, "Pune");
	}
	
}
