package com.cambia.exercise.adoption.validator;

import org.junit.Test;

import junit.framework.Assert;

public class PetDataValidatorTest {

	PetDataValidator validator = new PetDataValidator();
	
	/**
	 * Test valid pet type
	 */
	@Test
	public void testType(){
		
		boolean result = validator.validateType(null);
		Assert.assertEquals(false, result);
		
		//In-valid case
		result = validator.validateType("  ");
		Assert.assertEquals(false, result);
		
		result = validator.validateType(" Xy ");
		Assert.assertEquals(false, result);
		
		result = validator.validateType("xyz");
		Assert.assertEquals(false, result);
		
		result = validator.validateType("  DOG");
		Assert.assertEquals(false, result);
		
		//Valid case
		result = validator.validateType("Dog");
		Assert.assertEquals(true, result);
		
		result = validator.validateType("DOG");
		Assert.assertEquals(true, result);
	}
	
	/**
	 * Test valid pet gender
	 */
	@Test
	public void testGender(){
		
		boolean result = validator.validateGender(null);
		Assert.assertEquals(false, result);
		
		//In-valid case
		result = validator.validateGender("  ");
		Assert.assertEquals(false, result);
		
		result = validator.validateGender(" Xy ");
		Assert.assertEquals(false, result);
		
		result = validator.validateGender("xyz");
		Assert.assertEquals(false, result);
		
		result = validator.validateGender("  Male");
		Assert.assertEquals(false, result);
		
		//Valid case
		result = validator.validateGender("Male");
		Assert.assertEquals(true, result);
		
		result = validator.validateGender("FEMALE");
		Assert.assertEquals(true, result);
	}
	
	/**
	 * Test valid zipcode
	 */
	@Test
	public void testZipCode(){
		
		boolean result = validator.validateZipCode(null);
		Assert.assertEquals(false, result);
		
		//In-valid case
		result = validator.validateZipCode("  ");
		Assert.assertEquals(false, result);
		
		result = validator.validateZipCode("12");
		Assert.assertEquals(false, result);
		
		result = validator.validateZipCode(" 9408");
		Assert.assertEquals(false, result);
		
		//Valid case
		result = validator.validateZipCode("12345");
		Assert.assertEquals(true, result);
		
	}
	
	/**
	 * Test valid name
	 */
	@Test
	public void testName(){
		
		boolean result = validator.validateName(null);
		Assert.assertEquals(false, result);
		
		//In-valid case
		result = validator.validateName("  ");
		Assert.assertEquals(false, result);
		
		result = validator.validateName("12");
		Assert.assertEquals(false, result);
		
		//Expecting without any space (only first-name)
		result = validator.validateName("ABC ");
		Assert.assertEquals(false, result);
		
		//Valid case
		result = validator.validateName("Ac");
		Assert.assertEquals(true, result);
		
		result = validator.validateName("ABC");
		Assert.assertEquals(true, result);
		
		
		
	}
}
