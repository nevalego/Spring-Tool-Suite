package com.coches.repositorios;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFactory {

	CarsRepository getCars();

	PeopleRepository getPeople();
}
