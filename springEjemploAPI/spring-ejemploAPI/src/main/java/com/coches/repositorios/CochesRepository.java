package com.coches.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coches.entities.Coche;

@Repository
public interface CochesRepository extends JpaRepository<Coche, Long> {

	
}
