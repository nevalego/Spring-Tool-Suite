package com.coches.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coches.entidades.Coche;

@Repository
public interface CochesRepository extends JpaRepository<Coche, Long> {
//
//	public Coche save(Coche coche);
//	
//	public List<Coche> saveAll(List<Coche> coches);
//	public boolean exist(Long id);
//	public Coche findOne(Long id) ;
//	
//	public List<Coche> findAll(List<Coche> coches);
//	public List<Coche> findAll();
//	
//	public long count();
//	
//	public void delete(Long id);
//	public void delete(List<Coche> coches);
//	public void deleteAll();
	
}
