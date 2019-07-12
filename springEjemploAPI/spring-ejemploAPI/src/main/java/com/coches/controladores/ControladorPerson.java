package com.coches.controladores;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coches.controladores.impl.person.DeletePerson;
import com.coches.controladores.impl.person.FindAllPerson;
import com.coches.controladores.impl.person.FindPersonById;
import com.coches.controladores.impl.person.SavePerson;
import com.coches.entities.ErrorResponseEntity;
import com.coches.services.ServiceFactory;
import com.coches.services.dtos.PersonDto;

@RestController
@RequestMapping("/persona")
public class ControladorPerson {

	private ServiceFactory serviceFactory;

	@Autowired
	public ControladorPerson(ServiceFactory instanceServiceFactory) {
		this.serviceFactory = instanceServiceFactory;
	}

	@GetMapping("/")
	public String Vacio() {
		return "La información no está";
	}

	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		try {
			List<PersonDto> peopleDtoList = new FindAllPerson(serviceFactory).execute();
			return new ResponseEntity<>(peopleDtoList, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		}

	}
	
	@GetMapping("/find/{personID}")
	public ResponseEntity<?> findById(@PathVariable Long personID){
		try {
			List<PersonDto> peopleDtoList = new FindPersonById(serviceFactory, personID).execute();
			return new ResponseEntity<>(peopleDtoList,HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		}
	}

	@DeleteMapping("/delete/{personID}")
	public ResponseEntity<?> delete(@PathVariable Long personID) {
		try {
			List<PersonDto> personDtolist = new DeletePerson(serviceFactory, personID).execute();
			return new ResponseEntity<>(personDtolist, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody String json) {

		List<PersonDto> personDtolist = null;
		try {
			personDtolist = new SavePerson(serviceFactory, json).execute();
		} catch (IOException e) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		} catch (DataIntegrityViolationException e) {
			return ErrorResponseEntity.getErrorResponseEntity()
					.returnResponseEntity(e.getMessage());
		} catch (IllegalArgumentException e) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		}
		if (personDtolist == null) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity("Error al añadir la persona");
		} else {
			return new ResponseEntity<>(personDtolist, HttpStatus.OK);
		}

	}
}
