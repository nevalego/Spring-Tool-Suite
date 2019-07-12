package com.coches.controladores.impl.person;

import java.util.List;

import com.coches.services.ServiceFactory;
import com.coches.services.dtos.PersonDto;
import com.coches.util.Command;

public class FindAllPerson implements Command<List<PersonDto>>{

	private ServiceFactory serviceFactory;
	
	public FindAllPerson(ServiceFactory serviceFactory) {
		this.serviceFactory=serviceFactory;
	}

	@Override
	public List<PersonDto> execute() {
		
		return serviceFactory.getPeople().findAll();
	}
	

}
