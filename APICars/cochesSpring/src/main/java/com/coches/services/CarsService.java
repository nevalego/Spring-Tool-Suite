package com.coches.services;

import java.util.List;

import com.coches.services.dtos.CarDto;

public interface CarsService {

	List<CarDto> save(CarDto carDto);

	List<CarDto> findById(Long cocheID);

	List<CarDto> delete(Long cocheID);

	List<CarDto> findAll();
	
}
