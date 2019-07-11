package com.coches.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coches.services.CarsService;
import com.coches.services.ServiceFactory;

@Service
public class ServiceFactoryImpl implements ServiceFactory {
	
	
	private CarsService carsService;
	
	@Autowired
	public ServiceFactoryImpl(CarsService carsService) {
		this.carsService=carsService;
	}


	@Override
	public CarsService getCoches() {
		
		return carsService;
	}

}
