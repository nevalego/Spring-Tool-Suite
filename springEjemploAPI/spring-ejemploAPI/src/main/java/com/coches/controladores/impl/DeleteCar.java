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

	public DeleteCar(ServiceFactory serviceFactory, Long cocheID) {
		this.serviceFactory = serviceFactory;
		this.cocheID = cocheID;
	}

	@Override
	public List<CarDto> execute() throws Exception {


		List<CarDto> cochesDtoList = serviceFactory.getCoches().findById(cocheID);

		if (!cochesDtoList.isEmpty()) {
			return serviceFactory.getCoches().delete(cocheID);

		} else {
			throw new IllegalArgumentException("No existe el coche con ese ID");
		}

	}

}
