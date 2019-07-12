package com.coches.services;

import java.util.List;

import com.coches.services.dtos.PersonDto;

public interface PeopleService {

	List<PersonDto> save(PersonDto personDto);

	List<PersonDto> findById(Long personID);

	List<PersonDto> delete(Long personID);

	List<PersonDto> findAll();
	
}
