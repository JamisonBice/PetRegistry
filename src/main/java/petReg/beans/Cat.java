package petReg.beans;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
@Entity
@Getter
@Setter
public class Cat extends Pet {
	
	private String color;
	private String weight;

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cat(String name, int age, Owner owner, String color, String weight) {
		super(name, age, owner);
		this.color = color;
		this.weight = weight;
		// TODO Auto-generated constructor stub
		
	}
	
	

}
