package com.coches.services.dtos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coches.services.dtos.DtoAssemblerCar;
import com.coches.services.dtos.DtoAssemblerPerson;
import com.coches.services.dtos.DtoFactory;

@Service
public class DtoFactoryImpl implements DtoFactory{
	
	
	private DtoAssemblerCar dtoAssemblerCar;
	private DtoAssemblerPerson dtoAssemblerPerson;
	
	public DtoFactoryImpl() {}
	
	@Autowired
	public DtoFactoryImpl(DtoAssemblerCar dtoAssemblerCar, DtoAssemblerPerson dtoAssemblerPerson) {
		this.dtoAssemblerCar=dtoAssemblerCar;
		this.dtoAssemblerPerson=dtoAssemblerPerson;
	}
	
	@Override
	public DtoAssemblerCar getCars() {
		return dtoAssemblerCar;
	}

	@Override
	public DtoAssemblerPerson getPeople() {
		return dtoAssemblerPerson;
	}

}
