package com.coches.controladores.impl.person;

import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.PersonDto;
import com.coches.util.Command;

public class FindPersonById implements Command<List<PersonDto>> {

	private ServiceFactory serviceFactory;
	private Long personID;

	public FindPersonById(ServiceFactory serviceFactory, Long personID) {
		this.serviceFactory = serviceFactory;
		this.personID = personID;
	}

	@Override
	public List<PersonDto> execute() {
		List<PersonDto> personDtoList = serviceFactory.getPeople().findById(personID);

		if (!personDtoList.isEmpty()) {
			return personDtoList;

		} else {
			throw new IllegalArgumentException("No existe persona con ese ID");
		}

	}
}
