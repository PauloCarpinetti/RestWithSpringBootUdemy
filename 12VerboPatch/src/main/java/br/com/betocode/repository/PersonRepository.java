package br.com.betocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.betocode.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	@Modifying
	@Query("UPDATE Person p SET p.enabled = false WHERE p.id =:id")
	void disablePersons(@Param("id") Long id);
	
	@Modifying
	@Query("UPDATE Person p SET p.enabled = true WHERE p.id =:id")
	void enablePersons(@Param("id") Long id);
}
