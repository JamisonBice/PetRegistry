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
public class Dog extends Pet {
	
	private String type;
	private String weight;
	private String size;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String name, int age, Owner owner, String type, String weight, String size) {
		super(name, age, owner);
		this.type = type;
		this.weight = weight;
		this.size = size;

		// TODO Auto-generated constructor stub
		
	}
	
	

}
