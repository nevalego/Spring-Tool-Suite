package com.coches.controladores.impl;

import java.io.IOException;
import java.util.List;

import com.coches.entities.types.CocheDto;
import com.coches.services.ServiceFactory;
import com.coches.util.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveCoche implements Command<List<CocheDto>> {
	private ServiceFactory serviceFactory;
	private String json;

	public SaveCoche(ServiceFactory serviceFactory, String json) {
		this.serviceFactory = serviceFactory;
		this.json = json;
	}

	@Override
	public List<CocheDto> execute() throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		CocheDto dto = objectMapper.readValue(json, CocheDto.class);
		return serviceFactory.getCoches().save(dto);
	}

}
