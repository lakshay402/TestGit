package com.lombokJar.examples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode  //we can use @Data instead of Getter. Setter, ToString and EqualsAnsHashCode
@Data
public class TestLombok {
	
	private String name;
	private String email;
	private String address;
	private int age;
	private boolean isActive;
	
	
//	public TestLombok()
//	{
//		System.out.println("Default COnstructor");
//	}
//	
//	
//	//parametarize constructor
//	
//	public TestLombok(String name, String email, String address, int age, boolean isActive) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.address = address;
//		this.age = age;
//		this.isActive = isActive;
//	}



	//Generally we create Getter and Setter methods to access these variable to set and get values like:
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public boolean isActive() {
//		return isActive;
//	}
//	public void setActive(boolean isActive) {
//		this.isActive = isActive;
//	}
//	
//	@Override
//	public String toString() {
//		return "TestLombok [name=" + name + ", email=" + email + ", address=" + address + ", age=" + age + ", isActive="
//				+ isActive + "]";
//	}
	

}
