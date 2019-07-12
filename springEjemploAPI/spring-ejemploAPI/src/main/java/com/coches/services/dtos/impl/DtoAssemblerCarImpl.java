package com.coches.services.dtos.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coches.entities.Car;
import com.coches.services.dtos.CarDto;
import com.coches.services.dtos.DateConverter;
import com.coches.services.dtos.DtoAssemblerCar;


@Service
public class DtoAssemblerCarImpl implements DtoAssemblerCar {

	private DateConverter dateConverter;

	@Autowired
	public DtoAssemblerCarImpl(DateConverter dateConverter) {
		this.dateConverter=dateConverter;
	}

	@Override
	public CarDto carToDto(Car car) {
		CarDto carDto = new CarDto();
		carDto.id = car.getId();
		carDto.matricula = car.getMatricula();
		carDto.caballos = car.getCaballos();
		carDto.modelo = car.getModelo();

		if (car.getPerson() != null) {
			carDto.persona = car.getPerson();
		}
		return carDto;
	}

	@Override
	public Car dtoToCar(CarDto carDto) {
		Car car = new Car();
		car.setId(carDto.id);
		car.setMatricula(carDto.matricula);
		car.setModelo(carDto.modelo);
		car.setCaballos(carDto.caballos);
		
		if(carDto.persona != null) {
			car.setPerson(carDto.persona);
		}
		
		return car;
	}

	@Override
	public List<CarDto> listToDto(List<Car> carsList) {
		List<CarDto> carDtosList = new ArrayList<>();
		for (Car car : carsList)
			carDtosList.add(carToDto(car));
		return carDtosList;
	}

	@Override
	public List<Car> dtoToList(List<CarDto> carDtosList) {
		List<Car> carsList = new ArrayList<>();
		for (CarDto carDto : carDtosList)
			carsList.add(dtoToCar(carDto));
		return carsList;
	}

}
