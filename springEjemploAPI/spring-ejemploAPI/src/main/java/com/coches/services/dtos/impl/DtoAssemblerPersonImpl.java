package com.coches.services.dtos.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coches.entities.Person;
import com.coches.services.dtos.DateConverter;
import com.coches.services.dtos.DtoAssemblerPerson;
import com.coches.services.dtos.PersonDto;

@Service
public class DtoAssemblerPersonImpl implements DtoAssemblerPerson {

	private DateConverter dateConverter;

	@Autowired
	public DtoAssemblerPersonImpl(DateConverter dateConverter) {
		this.dateConverter = dateConverter;
	}

	@Override
	public PersonDto personToDto(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.id = person.getId();
		personDto.nombre = person.getNombre();
		personDto.apellidos = person.getApellidos();
		personDto.ciudad = person.getCiudad();
		personDto.dni=person.getDni();
		if (person.getFechaNacimiento() != null)
			personDto.fechaNacimiento = dateConverter.dateToString(person.getFechaNacimiento());
		return personDto;
	}

	@Override
	public Person dtoToPerson(PersonDto personDto) {
		Person person = new Person();
		person.setId(personDto.id);
		person.setNombre(personDto.nombre);
		person.setApellidos(personDto.apellidos);
		person.setCiudad(personDto.ciudad);
		person.setDni(personDto.dni);
		if (personDto.fechaNacimiento != null && !personDto.fechaNacimiento.equals("null")) {
			person.setFechaNacimiento(dateConverter.stringToDate(personDto.fechaNacimiento));
		}
		return person;
	}

	@Override
	public List<PersonDto> listToDto(List<Person> people) {
		List<PersonDto> peopleDtoList = new ArrayList<>();
		for (Person person : people)
			peopleDtoList.add(personToDto(person));
		return peopleDtoList;
	}

	@Override
	public List<Person> dtoToList(List<PersonDto> peopleDtoList) {
		List<Person> peopleList = new ArrayList<>();
		for (PersonDto personDto : peopleDtoList)
			peopleList.add(dtoToPerson(personDto));
		return peopleList;
	}

}
