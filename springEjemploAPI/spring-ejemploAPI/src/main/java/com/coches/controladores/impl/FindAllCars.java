package com.coches.controladores.impl;

import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.CarDto;
import com.coches.util.Command;

public class FindAllCars implements Command<List<CarDto>>{

	private ServiceFactory serviceFactory;
	
	public FindAllCars(ServiceFactory serviceFactory) {
		this.serviceFactory=serviceFactory;
	}

	@Override
	public List<CarDto> execute() {
		
		return serviceFactory.getCoches().findAll();
	}
	

}
