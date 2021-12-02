package petReg.beans;

import javax.persistence.Embeddable;
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
//@Embeddable
@Entity
@Data
@NoArgsConstructor
public class Owner {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private int houseNum;
	private int age;
	/**
	 * @param id
	 * @param name
	 * @param houseNum
	 * @param age
	 */
	public Owner(int id, String name, int houseNum, int age) {
		this.id = id;
		this.name = name;
		this.houseNum = houseNum;
		this.age = age;
	}
	/**
	 * @param name
	 * @param houseNum
	 * @param age
	 */
	public Owner(String name, int houseNum, int age) {
		this.name = name;
		this.houseNum = houseNum;
		this.age = age;
	}

	
}
