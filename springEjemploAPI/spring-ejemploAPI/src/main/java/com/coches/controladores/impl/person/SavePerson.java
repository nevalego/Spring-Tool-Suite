package com.coches.controladores.impl.person;

import java.io.IOException;
import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.PersonDto;
import com.coches.util.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SavePerson implements Command<List<PersonDto>> {
	private ServiceFactory serviceFactory;
	private String json;

	public SavePerson(ServiceFactory serviceFactory, String json) {
		this.serviceFactory = serviceFactory;
		this.json = json;
	}

	@Override
	public List<PersonDto> execute() throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		PersonDto dto = objectMapper.readValue(json, PersonDto.class);
		return serviceFactory.getPeople().save(dto);
	}

}
