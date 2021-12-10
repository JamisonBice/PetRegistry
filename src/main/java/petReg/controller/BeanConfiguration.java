package petReg.controller;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import petReg.beans.Owner;
import petReg.beans.Pet;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Nov 17, 2021
 */

//Configs the beans
@Configuration
public class BeanConfiguration {
	@Bean
	public Pet pet() {
		Pet bean = new Pet();
		return bean;

	}

	@Bean
	public Owner owner() {
		Owner bean = new Owner();

		return bean;

	}
}
