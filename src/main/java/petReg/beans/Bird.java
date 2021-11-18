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
public class Bird extends Pet {
	
	private String color;
	private  int wingSpan;

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bird(String name, int age, Owner owner, String color, int wingSpan) {
		super(name, age, owner);
		this.color = color;
		this.wingSpan = wingSpan;
		// TODO Auto-generated constructor stub
		
	}
	
	

}
