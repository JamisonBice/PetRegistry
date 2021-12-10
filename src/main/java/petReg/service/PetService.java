package petReg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import petReg.beans.Pet;
import petReg.repository.PetRepository;

@Service
@Transactional
public class PetService {

	@Autowired
	private PetRepository repo;

	// Gets all the Pet Objects/List
	public List<Pet> getAllPets() {
		List<Pet> list = (List<Pet>) repo.findAll();
		return list;
	}

	// Uses the keyword to find an element in the database
	public List<Pet> getByKeyword(String keyword) {
		return repo.findByKeyword(keyword);
	}

	// Saves pet
	public void save(Pet pet) {
		repo.save(pet);
	}

	// Finds by ID
	public Pet get(long id) {
		return repo.findById(id).get();
	}

	// Deletes By ID
	public void delete(long id) {
		repo.deleteById(id);
	}
}