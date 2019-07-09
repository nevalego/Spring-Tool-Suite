package com.coches.controladores.impl;

import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.CarDto;
import com.coches.util.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteCar implements Command<List<CarDto>> {

	private ServiceFactory serviceFactory;
	private Long cocheID;
	private String json;

	public DeleteCar(ServiceFactory serviceFactory, Long cocheID, String json) {
		this.serviceFactory = serviceFactory;
		this.cocheID = cocheID;
		this.json = json;
	}

	@Override
	public List<CarDto> execute() throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		CarDto carDto = objectMapper.readValue(json, CarDto.class);

		List<CarDto> cochesDtoList = serviceFactory.getCoches().findById(carDto.id);

		if (!cochesDtoList.isEmpty()) {
			carDto.id = this.cocheID;
			return serviceFactory.getCoches().delete(cocheID);

		} else {
			throw new IllegalArgumentException("No se ha podido eliminar el dispositivo");
		}

	}

}
