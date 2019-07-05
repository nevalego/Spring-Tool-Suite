package com.ejemplo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.entidades.Coche;
import com.ejemplo.repositorios.CochesRepository;

@Service
public class CochesService {

	@Autowired
	private CochesRepository cochesRepository;

	public List<Coche> getCoches(){
		List<Coche> coches = cochesRepository.findAll();
		return coches;
	}
	
	
	
}
