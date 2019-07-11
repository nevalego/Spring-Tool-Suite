package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.coches.entities.Car;

public class CarEntityTest {

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
	public void testNegativeId() {
		this.car.setId(-3L);
		Assert.assertTrue(car.getId() > 0L);
	}
	
	@Test
	public void testZeroId(){
		this.car.setId(0L);
		Assert.assertTrue(car.getId() > 0L);
	}
	
	@Test
	public void testEmptyMatricula() {
		this.car.setMatricula("");
		Assert.assertFalse(car.getMatricula().isEmpty() );
	}
	
	 @Test
	 public void testNullMatricula() {
		 this.car.setMatricula(null);
		 Assert.assertFalse(car.getMatricula()== null);
	 }
		 
	 @Test
	 public void testWrongMatricula() {
		 this.car.setMatricula("R");
		 Assert.assertFalse(  Car.isCorrect(car.getMatricula()));
		 this.car.setMatricula("19274823");
		 Assert.assertFalse(  Car.isCorrect(car.getMatricula()));
	 }
	 
	 @Test
	 public void testNegativeCaballos() {
		 this.car.setCaballos(-293);
			Assert.assertTrue(car.getCaballos() == Car.DEFAULT_CABALLOS);
	 }
	 
	 @Test
	 public void testZeroCaballos() {
		 this.car.setCaballos(0);
			Assert.assertTrue(car.getCaballos() == Car.DEFAULT_CABALLOS);
	 }
	 
	 
	 

}
