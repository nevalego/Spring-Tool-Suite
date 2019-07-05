package com.ejemplo.repositorios;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ejemplo.entidades.Coche;

@Repository
public class CochesRepository {

	
	
	public Coche save(Coche coche) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Coche> saveAll(List<Coche> coches) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Coche findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Coche> findAll(List<Coche> coches) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Coche> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long count() {
		return 0;
	}
	
	public void delete() {
		
	}
	
	public void delete(Coche coche) {
		
	}
	public void delete(List<Coche> coches) {
		
	}
	public void deleteAll() {
		
	}
	
}
