package petReg.beans;

import javax.persistence.Entity;


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
public class Owner {
	private String name;
	private int houseNum;
	private int age;
	
}
