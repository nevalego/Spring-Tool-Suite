package com.coches.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coches.entidades.Coche;
import com.coches.repositorios.CochesRepository;

@Service
public class CochesService {

	@Autowired
	private CochesRepository cochesRepository;

	public List<Coche> getCoches(){
		List<Coche> coches = cochesRepository.findAll();
		return coches;
	}
	
	
	public void deleteCoche(Long cocheID){
		cochesRepository.deleteById(cocheID);
	}
	
	
}
