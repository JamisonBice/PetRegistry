package petReg.repository;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petReg.beans.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
