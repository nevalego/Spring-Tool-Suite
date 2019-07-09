package com.coches.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coches.entities.Car;
import com.coches.services.dtos.CarDto;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

	List<CarDto> findByMatricula(String matricula);
	
}
