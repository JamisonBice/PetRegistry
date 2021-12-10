package petReg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import petReg.beans.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	// Custom query which searches the name, species, weight, color, and age for the
	// 'Keyword'
	@Query(value = "select * from pet p where p.name like %:keyword% or p.species like %:keyword% or p.age like %:keyword% or p.weight like %:keyword% or p.color like %:keyword% ", nativeQuery = true)
	List<Pet> findByKeyword(@Param("keyword") String keyword);
}
