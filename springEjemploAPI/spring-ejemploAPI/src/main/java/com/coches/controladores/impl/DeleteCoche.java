package com.coches.controladores.impl;

import java.util.List;

import com.coches.entities.types.CocheDto;
import com.coches.services.ServiceFactory;
import com.coches.util.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteCoche implements Command<List<CocheDto>> {

	private ServiceFactory serviceFactory;
	private Long cocheID;
	private String json;

	public DeleteCoche(ServiceFactory serviceFactory, Long cocheID, String json) {
		this.serviceFactory = serviceFactory;
		this.cocheID = cocheID;
		this.json = json;
	}

	@Override
	public List<CocheDto> execute() throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		CocheDto cocheDto = objectMapper.readValue(json, CocheDto.class);
		
		List<CocheDto> cochesDtoList =serviceFactory.getCoches().findById(cocheDto.id);
        
        if (!cochesDtoList.isEmpty()) {
            cocheDto.id = this.cocheID;
            serviceFactory.getCoches().deleteCoche(cocheID);
            return 
            } else {
                throw new IllegalArgumentException(
                        "No se ha podido eliminar el dispositivo");
            }
		
	}

}
