package petReg.controller;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import petReg.beans.Bird;
import petReg.beans.Cat;
import petReg.beans.Dog;
import petReg.beans.Fish;
import petReg.beans.Pet;


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
}
