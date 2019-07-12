package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coches.controladores.ControladorCoches;
import com.coches.services.CarsService;
import com.coches.services.PeopleService;
import com.coches.services.dtos.CarDto;
import com.coches.services.impl.ServiceFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class CarControllerTest {

	private ControladorCoches carController;
	private CarDto carAurisDto;
	private CarDto carFordDto;

	@Mock
	private CarsService carsService;
	private PeopleService peopleService;
	private ServiceFactoryImpl serviceFactory;

	private List<CarDto> carsDtoList = new ArrayList<>();

	@Before
	public void initTest() {

		this.carAurisDto = new CarDto();
		this.carAurisDto.id = 40L;
		this.carAurisDto.matricula = "3729ERM";
		this.carAurisDto.modelo = "Auris";
		this.carAurisDto.caballos=105;

		this.carFordDto = new CarDto();
		this.carFordDto.id = 40L;
		this.carFordDto.matricula = "7392ERI";
		this.carFordDto.modelo = "Ford Fiesta";
		this.carFordDto.caballos=85;

		serviceFactory = new ServiceFactoryImpl(carsService,peopleService);
		this.carController = new ControladorCoches(serviceFactory);

	}

	@Test
	public void testFindAllWithNoCars() {

		ResponseEntity<?> res = this.carController.findAll();
		Assert.assertEquals(HttpStatus.OK, res.getStatusCode());
		Assert.assertEquals(carsDtoList, res.getBody());
	}
	
	@Test
	public void testSaveCar() {
		
		String json = "{"+
				"	\"matricula\":\"7302RIC\","+
				"	\"modelo\":\"Auris\","+
				"	\"caballos\":105"+
			"}";

		ResponseEntity<?> res=this.carController.save(json);
		Assert.assertEquals(HttpStatus.OK, res.getStatusCode());
		
		res = this.carController.findAll();
		Assert.assertEquals(HttpStatus.OK, res.getStatusCode());

	}
	
	@Test
	public void testSaveRepeatedMatriculaCar() {
		
		String json = "{"+
				"	\"matricula\":\"7302RIC\","+
				"	\"modelo\":\"Seat Panda\","+
				"	\"caballos\":100"+
			"}";

		ResponseEntity<?> res=this.carController.save(json);		
		Assert.assertEquals(HttpStatus.OK, res.getStatusCode());
	}
	
	@Test
	public void testDeleteNonExistingCar() {
		
		ResponseEntity<?> res = this.carController.delete(6L);
		 Assert.assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
		 HashMap<String, String> error = getErrorResponse(
	                "No existe el coche con ese ID");
	        Assert.assertEquals(error, res.getBody());
	}

    private HashMap<String, String> getErrorResponse(String s) {
        HashMap<String, String> error = new HashMap<>();
        error.put("Error", s);
        return error;
    }
}
