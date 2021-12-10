package petReg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Nov 17, 2021
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int age;
	private String species;
	private String weight;
	private String color;

	/**
	 * @param name
	 * @param age
	 * @param species
	 * @param weight
	 * @param color
	 * @param owner
	 */

	public Pet(String name, int age, String species, String weight, String color) {

		this.name = name;
		this.age = age;
		this.species = species;
		this.weight = weight;
		this.color = color;
	}

	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param species
	 * @param weight
	 * @param color
	 * @param owner
	 */
	public Pet(long id, String name, int age, String species, String weight, String color) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.species = species;
		this.weight = weight;
		this.color = color;
	}
}
