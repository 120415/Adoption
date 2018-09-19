package com.cambia.exercise.adoption.reader;

import java.util.List;

import org.junit.Test;

import com.cambia.exercise.adoption.vo.PetDetails;

import junit.framework.Assert;

public class InputDataReaderTest {

	InputDataReader reader = new InputDataReader();
	
	/**
	 * Test empty data-set
	 */
	@Test
	public void testEmptyDataReader(){
		List<PetDetails> result = reader.readPets("./src/test/resources/empty.csv");
		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.size());
	}
	
	/**
	 * Test data-set with only header
	 */
	@Test
	public void testHeaderDataReader(){
		List<PetDetails> result = reader.readPets("./src/test/resources/header.csv");
		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.size());
	}
	
	/**
	 * Test invalid structure of the data-set
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidDataReader(){
		List<PetDetails> result = reader.readPets("./src/test/resources/invalid.csv");
		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.size());
	}
	
	/**
	 * Test valid structure of the data-set
	 */
	@Test
	public void testValidDataReader(){
		List<PetDetails> result = reader.readPets("./src/test/resources/proper.csv");
		Assert.assertNotNull(result);
		Assert.assertEquals(8, result.size());
	}
	
}
