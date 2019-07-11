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

import com.coches.controladores.impl.DeleteCar;
import com.coches.controladores.impl.FindAllCars;
import com.coches.controladores.impl.SaveCar;
import com.coches.entities.ErrorResponseEntity;
import com.coches.services.LogService;
import com.coches.services.ServiceFactory;
import com.coches.services.dtos.CarDto;

@RestController
@RequestMapping("/coche")
public class ControladorCoches {

	private ServiceFactory serviceFactory;
	private LogService logService;

	@Autowired
	public ControladorCoches(ServiceFactory instanceServiceFactory) {
		this.serviceFactory = instanceServiceFactory;
		this.logService = new LogService(this);
	}

	@GetMapping("/")
	public String Vacio() {
		return "La información no está";
	}

	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		try {
			List<CarDto> cocheDtoList = new FindAllCars(serviceFactory).execute();
			return new ResponseEntity<>(cocheDtoList, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		}

	}

	@DeleteMapping("/delete/{cocheID}")
	public ResponseEntity<?> delete(@PathVariable Long cocheID) {
		
		try {
			List<CarDto> list = new DeleteCar(serviceFactory, cocheID).execute();
			logService.info("Coche borrado ");
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody String json) {

		List<CarDto> cocheDtoList = null;
		try {
			cocheDtoList = new SaveCar(serviceFactory, json).execute();
		} catch (IOException e) {
			logService.info(" Intenta añadir coche, pero " + e.getMessage());
		} catch (DataIntegrityViolationException e) {
			logService.info(" Intenta añadir coche, pero " + e.getMessage());
			return ErrorResponseEntity.getErrorResponseEntity()
					.returnResponseEntity("Ya existe un coche con ese " + "identificador");
		} catch (IllegalArgumentException e) {
			logService.info(" Intenta añadir coche, pero " + e.getMessage());
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity(e.getMessage());
		}
		if (cocheDtoList == null) {
			return ErrorResponseEntity.getErrorResponseEntity().returnResponseEntity("Error al añadir al coche");
		} else {
			logService.info("Coche guardado ");
			return new ResponseEntity<>(cocheDtoList, HttpStatus.OK);
		}

	}
}