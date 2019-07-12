package com.coches.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coches.entities.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

	/**
	 * Finds person by using the NIF as a search criteria
	 * @param NIF
	 * @return A list of cars which plate is an exact match with the given NIF.
	 * 			If no person is found, this method returns an empty list.
	 */
	@Query
	List<Person> findByDNI(String dni);
	
}
