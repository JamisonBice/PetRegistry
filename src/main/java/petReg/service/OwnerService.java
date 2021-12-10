package petReg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petReg.beans.Owner;
import petReg.repository.OwnerRepository;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Dec 1, 2021
 */

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository repository;

	// Gets all the Owner Objects/List
	public List<Owner> getAllOwners() {
		List<Owner> list = (List<Owner>) repository.findAll();
		return list;
	}

	// Uses the keyword to find an element in the database
	public List<Owner> getByKeyword(String keyword) {
		return repository.findByKeyword(keyword);
	}
	 /*//Gets the count of the Keyword 
	public long countKeyword(String keyword) {
		return repository.countBy(keyword);
	}
	
	//Gets the count of the the elements in database
	public long count() {
		return repository.count();
	}
	*/
	
}
