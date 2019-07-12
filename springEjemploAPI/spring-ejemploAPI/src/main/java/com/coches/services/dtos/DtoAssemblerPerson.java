package com.coches.services.dtos;

import java.util.List;

import com.coches.entities.Person;

public interface DtoAssemblerPerson {

		PersonDto personToDto(Person person);

		Person dtoToPerson(PersonDto personDto);

		List<PersonDto> listToDto(List<Person> people);

		List<Person> dtoToList(List<PersonDto> peopleDtoList);
	

}
