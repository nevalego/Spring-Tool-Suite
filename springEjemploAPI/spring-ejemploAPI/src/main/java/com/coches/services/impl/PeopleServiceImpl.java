package com.coches.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.coches.entities.Person;
import com.coches.repositorios.RepositoryFactory;
import com.coches.services.PeopleService;
import com.coches.services.dtos.DtoFactory;
import com.coches.services.dtos.PersonDto;

@Service
public class PeopleServiceImpl implements PeopleService {

	private RepositoryFactory repositoryFactory;
	private DtoFactory dtoFactory;

	@Autowired
	public PeopleServiceImpl(RepositoryFactory repositoryFactory, DtoFactory dtoFactory) {
		this.repositoryFactory = repositoryFactory;
		this.dtoFactory = dtoFactory;
	}

	@Override
	public List<PersonDto> save(PersonDto personDto) {

		List<Person> peopleList = repositoryFactory.getPeople().findByDNI(personDto.dni);

		if (peopleList.isEmpty()) {
			
			List<PersonDto> people = new ArrayList<>();
			
			people.add(dtoFactory.getPeople().personToDto(repositoryFactory
	                .getPeople().save(dtoFactory.getPeople().dtoToPerson(personDto))));
			
			return people;
		} else
			throw new DataIntegrityViolationException("Ya existe un coche con esa matrícula");
	}

	@Override
	public List<PersonDto> findById(Long personID) {
		Optional<Person> optional = repositoryFactory.getPeople().findById(personID);

		if (optional.isPresent()) {
			Person person = optional.get();
			List<Person> peopleList = new ArrayList<>();
			peopleList.add(person);
			return dtoFactory.getPeople().listToDto(peopleList);
		} else {
			throw new IllegalArgumentException("No se encuentra ninguna persona con ese ID");
		}
	}

	@Override
	public List<PersonDto> delete(Long personID) {
		Optional<Person> optional = repositoryFactory.getPeople().findById(personID);
		if (optional.isPresent()) {
			Person person = optional.get();
			repositoryFactory.getPeople().delete(person);
			optional = repositoryFactory.getPeople().findById(personID);
			if (optional.isPresent())
				throw new IllegalArgumentException("No se ha eliminado la persona con éxito");
			else {
				List<Person> peopleList = new ArrayList<>();
				peopleList.add(person);
				List<PersonDto> peopleDtosList = dtoFactory.getPeople().listToDto(peopleList);
				return peopleDtosList;
			}
		} else {
			throw new IllegalArgumentException("La persona no existe y por tanto no se puede eliminar");
		}
	}

	@Override
	public List<PersonDto> findAll() {
		List<Person> people = new ArrayList<>();

		people = repositoryFactory.getPeople().findAll();

		if (people == null)
			throw new IllegalArgumentException("Error al obtener el listado de las personas");
		else if (people.isEmpty()) {
			throw new IllegalArgumentException("No hay ninguna persona");
		} else {
			return dtoFactory.getPeople().listToDto(people);
		}

	}
}
