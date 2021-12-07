package petReg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "owner")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
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
