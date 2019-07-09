package com.coches.services.dtos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coches.entities.Car;
@Service
public interface DtoAssemblerCar {

		CarDto carToDto(Car car);

		Car dtoToCar(CarDto dto);

		List<CarDto> listToDto(List<Car> employees);

		List<Car> dtoToList(List<CarDto> employeeDtoList);
	

}
