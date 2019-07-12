package com.coches.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coches.services.CarsService;
import com.coches.services.PeopleService;
import com.coches.services.ServiceFactory;

@Service
public class ServiceFactoryImpl implements ServiceFactory {
	
	
	private CarsService carsService;
	private PeopleService peopleService;
	
	@Autowired
	public ServiceFactoryImpl(CarsService carsService,PeopleService peopleService) {
		this.carsService=carsService;
		this.peopleService=peopleService;
	}


	@Override
	public CarsService getCars() {
		
		return carsService;
	}


	@Override
	public PeopleService getPeople() {
		return peopleService;
	}

}
