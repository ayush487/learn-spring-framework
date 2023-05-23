package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) {}

// Address firstline and city
record Address (String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ayush";
	}
	
	@Bean
	public int age() {
		return 21;
	}

	@Bean
	public Person person() {
		var person = new Person("Ravi", 20, new Address("Main Stree", "Utrecht"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address());
		return person;
	}
	
	@Bean
	public Person person3Parameter(String name, int age, Address address2) { //name, age, address2
		var person = new Person(name, age, address2);
		return person;
	}
	
	@Bean
	public Person person4Parameter(String name, int age, Address yourCustomBeanAddress) {
		return new Person(name,age,yourCustomBeanAddress);
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
		return new Person(name, age,address);
	}
	
	@Bean(name = "yourCustomBeanAddress")
	public Address address() {
		var address = new Address("Baker Street", "London");
		return address;
	}
	
	@Bean
	public Address address2() {
		var address = new Address("Zako Street", "Seoul");
		return address;
	}
	
	@Bean(name="address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("Motinagar", "Hyderabad");
		return address;
	}
}
