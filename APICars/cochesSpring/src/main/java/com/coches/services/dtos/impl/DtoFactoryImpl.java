package com.coches.services.dtos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coches.services.dtos.DtoAssemblerCar;
import com.coches.services.dtos.DtoFactory;

@Service
public class DtoFactoryImpl implements DtoFactory{
	
	
	private DtoAssemblerCar dtoAssemblerCar;
	
	
	public DtoFactoryImpl() {}
	
	@Autowired
	public DtoFactoryImpl(DtoAssemblerCar dtoAssemblerCar) {
		this.dtoAssemblerCar=dtoAssemblerCar;
	}
	
	@Override
	public DtoAssemblerCar getCars() {
		return dtoAssemblerCar;
	}

}
