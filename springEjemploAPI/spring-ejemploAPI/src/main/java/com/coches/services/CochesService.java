package com.coches.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coches.entities.Coche;
import com.coches.entities.types.CocheDto;
import com.coches.repositorios.CochesRepository;

@Service
public class CochesService {

	@Autowired
	private CochesRepository cochesRepository;

	public List<Coche> getCoches() {
		List<Coche> coches = cochesRepository.findAll();
		return coches;
	}

	public void deleteCoche(Long cocheID) {
		cochesRepository.deleteById(cocheID);
	}

	public List<CocheDto> save(CocheDto dto) {
		// TODO
		return cochesRepository.save(dto);
	}

}
