package com.coches.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coches.entities.Car;
import com.coches.services.dtos.CarDto;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

	/**
	 * Finds car by using the plate as a search criteria
	 * @param matricula
	 * @return A list of cars which plate is an exact match with the given plate.
	 * 			If no car is found, this method returns an empty list.
	 */
	@Query
	List<CarDto> findByMatricula(String matricula);
	
}
