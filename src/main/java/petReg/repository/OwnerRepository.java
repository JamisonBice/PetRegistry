package petReg.repository;

import java.util.List;


/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import petReg.beans.Owner;
/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{
 //Custom query which search the name, houseNum, and age for the 'Keyword'
 @Query(value = "select * from owner o where o.name like %:keyword% or o.house_num like %:keyword% or o.age like %:keyword%" , nativeQuery = true)
 List<Owner> findByKeyword(@Param("keyword") String keyword);
 
 

}
