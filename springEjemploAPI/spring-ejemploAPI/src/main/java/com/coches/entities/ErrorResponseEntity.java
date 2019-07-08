package com.coches.entities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coches.services.LogService;

/**
 * Clase encargada de devolver la información de los errores ocurridos al
 * realizar las peticiones a la API
 * 
 *
 */
public class ErrorResponseEntity {
	private static ErrorResponseEntity errorResponseEntity;
	private LogService logService = new LogService(this);

	public static ErrorResponseEntity getErrorResponseEntity() {
		if (errorResponseEntity == null) {
			errorResponseEntity = new ErrorResponseEntity();
		}
		return errorResponseEntity;
	}

	public ResponseEntity<?> returnResponseEntity(String message) {
		logService.error(message);
		return new ResponseEntity<>(setMapErrors(message),
				HttpStatus.BAD_REQUEST);
	}

	private Map<String, String> setMapErrors(String message) {
		Map<String, String> map = new HashMap<>();
		map.put("Error", message);
		return map;
	}
}
