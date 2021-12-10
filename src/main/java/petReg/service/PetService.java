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
	
	public List<Pet> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Pet pet) {
		repo.save(pet);
	}
	
	public Pet get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}