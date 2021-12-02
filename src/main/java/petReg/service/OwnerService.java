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

	public List<Owner> getAllOwners() {
		List<Owner> list = (List<Owner>) repository.findAll();
		return list;
	}

	public List<Owner> getByKeyword(String keyword) {
		return repository.findByKeyword(keyword);
	}
}
