package com.coches.services.dtos;

import java.util.List;

import com.coches.entities.Car;

public interface DtoAssemblerCar {

		CarDto carToDto(Car car);

		Car dtoToCar(CarDto dto);

		List<CarDto> listToDto(List<Car> employees);

		List<Car> dtoToList(List<CarDto> employeeDtoList);
	

}
