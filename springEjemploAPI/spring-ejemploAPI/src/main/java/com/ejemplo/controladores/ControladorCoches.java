package com.ejemplo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.entidades.Coche;
import com.ejemplo.servicios.CochesService;

@RestController
public class ControladorCoches{
	
	
	@Autowired private CochesService cochesService=null;
	
	public ControladorCoches(CochesService instanceService) {
		this.cochesService=instanceService;
	}
	
	
	@RequestMapping ("/")
	 public String Vacio(){
		 return "La información no está"; 
	 }
	 @RequestMapping ("/coche/list")
	 public ResponseEntity<List<Coche>> getList(){
		 List<Coche> coches = cochesService.getCoches();
		 ResponseEntity<List<Coche>> request = new ResponseEntity<>(coches, HttpStatus.OK);
		 return request; 
	 }
	 
	 
}
