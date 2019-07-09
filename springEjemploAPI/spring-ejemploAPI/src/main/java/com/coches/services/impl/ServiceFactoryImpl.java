package com.coches.services.impl;

import org.springframework.stereotype.Service;

import com.coches.services.CarsService;
import com.coches.services.ServiceFactory;

@Service
public class ServiceFactoryImpl implements ServiceFactory {
	
	
	private CarsService carService;
	
	public ServiceFactoryImpl(CarsService carService) {
		this.carService=carService;
	}

	@Override
	public CarsService getCoches() {
		
		return null;
	}

}
