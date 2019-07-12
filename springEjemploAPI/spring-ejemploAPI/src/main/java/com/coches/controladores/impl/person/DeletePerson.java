package com.coches.controladores.impl.person;

import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.PersonDto;
import com.coches.util.Command;

public class DeletePerson implements Command<List<PersonDto>> {

	private ServiceFactory serviceFactory;
	private Long personID;
	private String json;

	public DeletePerson(ServiceFactory serviceFactory, Long personID, String json) {
		this.serviceFactory = serviceFactory;
		this.personID = personID;
		this.json = json;
	}

	public DeletePerson(ServiceFactory serviceFactory, Long personID) {
		this.serviceFactory = serviceFactory;
		this.personID = personID;
	}

	@Override
	public List<PersonDto> execute() throws Exception {


		List<PersonDto> personDtoList = serviceFactory.getPeople().findById(personID);

		if (!personDtoList.isEmpty()) {
			return serviceFactory.getPeople().delete(personID);

		} else {
			throw new IllegalArgumentException("No existe persona con ese ID");
		}

	}

}
