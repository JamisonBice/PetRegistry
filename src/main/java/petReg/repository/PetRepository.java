package petReg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import petReg.beans.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
	@Query("SELECT p FROM Pet p WHERE CONCAT(p.name, ' ', p.species, ' ', p.weight, ' ', p.color, ' ', p.age) LIKE %?1%")
	public List<Pet> search(String keyword); 
}

