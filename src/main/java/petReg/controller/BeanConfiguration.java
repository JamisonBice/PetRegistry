package petReg.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import petReg.beans.Bird;
import petReg.beans.Cat;
import petReg.beans.Dog;
import petReg.beans.Fish;
import petReg.beans.Pet;
import petReg.beans.Reptile;


/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
@Configuration
public class BeanConfiguration {
	@Bean
	public Pet pet() {
		Pet bean = new Pet();
		
		return bean;
	}
	@Bean
	public Pet dog() {
		Dog bean = new Dog();
		
		return bean;
	}
	@Bean
	public Pet cat() {
		Cat bean = new Cat();
		
		return bean;
	}
	@Bean
	public Pet fish() {
		Fish bean = new Fish();
		
		return bean;
	}
	@Bean
	public Pet bird() {
		Bird bean = new Bird();
		
		return bean;
	}
	@Bean
	public Pet reptile() {
		Reptile bean = new Reptile();
		
		return bean;
	}

	


}
