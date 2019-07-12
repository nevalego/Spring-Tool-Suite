package com.coches.controladores.impl.cars;

import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.CarDto;
import com.coches.util.Command;

public class FindCarById implements Command<List<CarDto>> {

	private ServiceFactory serviceFactory;
	private Long carID;

	public FindCarById(ServiceFactory serviceFactory, Long carID) {
		this.serviceFactory = serviceFactory;
		this.carID = carID;
	}

	@Override
	public List<CarDto> execute() {
		List<CarDto> carDtoList = serviceFactory.getCars().findById(carID);

		if (!carDtoList.isEmpty()) {
			return carDtoList;

		} else {
			throw new IllegalArgumentException("No existe coche con ese ID");
		}

	}
}
