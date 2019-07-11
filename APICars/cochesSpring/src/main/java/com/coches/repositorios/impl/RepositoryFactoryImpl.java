package com.coches.repositorios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coches.repositorios.CarsRepository;
import com.coches.repositorios.RepositoryFactory;
@Repository
public class RepositoryFactoryImpl implements RepositoryFactory {

	private CarsRepository carsRepository;
	
	
	public  RepositoryFactoryImpl() {
	}
	@Autowired
	public RepositoryFactoryImpl(CarsRepository carsRepository) {
		this.carsRepository=carsRepository;
	}
	

	@Override
	public CarsRepository getCars() {
		return carsRepository;
	}

}
