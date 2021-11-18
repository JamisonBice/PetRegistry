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
public class Reptile extends Pet {
	
	private String color;
	private String type;

	public Reptile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reptile(String name, int age, Owner owner, String color, String type) {
		super(name, age, owner);
		this.color = color;
		this.type = type;

		// TODO Auto-generated constructor stub
		
	}
	
	

}
