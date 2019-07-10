package com.example.demo;

import org.junit.Before;
import org.junit.Test;

import com.coches.entities.Car;

import org.junit.Assert;

public class CochesApplicationTests {

	private Car car;
	
	
	@Before
	public void initTest() {
		this.car= new Car();
		this.car.setId(2L);
		this.car.setMatricula("4819JRJ");
		this.car.setModelo("Mazda");
		this.car.setCaballos(94);
		
	}
	
	
	
	@Test
	public void testValidId() {
		Assert.assertTrue(car.getId() > 0L);
	}
	
	@Test
	public void testNegativegId() {
		this.car.setId(-3L);
		Assert.assertTrue(car.getId() > 0L);
	}
	

}
