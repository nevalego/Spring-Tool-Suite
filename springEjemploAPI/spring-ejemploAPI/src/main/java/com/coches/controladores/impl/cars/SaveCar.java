package com.coches.controladores.impl.cars;

import java.io.IOException;
import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.CarDto;
import com.coches.util.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveCar implements Command<List<CarDto>> {
	private ServiceFactory serviceFactory;
	private String json;

	public SaveCar(ServiceFactory serviceFactory, String json) {
		this.serviceFactory = serviceFactory;
		this.json = json;
	}

	@Override
	public List<CarDto> execute() throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		CarDto dto = objectMapper.readValue(json, CarDto.class);
		return serviceFactory.getCars().save(dto);
	}

}
