package petReg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */

@Entity
@Data
@NoArgsConstructor
public class Pet {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private int age;
	private Owner owner;
	/**
	 * @param name
	 * @param age
	 * @param owner
	 */
	public Pet(String name, int age, Owner owner) {
		this.name = name;
		this.age = age;
		this.owner = owner;
	}
	
	

}
