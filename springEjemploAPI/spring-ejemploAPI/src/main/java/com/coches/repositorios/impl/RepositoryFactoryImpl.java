package com.coches.repositorios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coches.repositorios.CarsRepository;
import com.coches.repositorios.PeopleRepository;
import com.coches.repositorios.RepositoryFactory;
@Repository
public class RepositoryFactoryImpl implements RepositoryFactory {

	private CarsRepository carsRepository;
	private PeopleRepository peopleRepository;
	
	public  RepositoryFactoryImpl() {
	}
	@Autowired
	public RepositoryFactoryImpl(CarsRepository carsRepository, PeopleRepository peopleRepository) {
		this.carsRepository=carsRepository;
		this.peopleRepository=peopleRepository;
	}
	

	@Override
	public CarsRepository getCars() {
		return carsRepository;
	}
	@Override
	public PeopleRepository getPeople() {
		return peopleRepository;
	}

}
