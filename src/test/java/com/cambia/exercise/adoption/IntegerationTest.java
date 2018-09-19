package com.cambia.exercise.adoption;

import java.util.List;

import org.junit.Test;

import com.cambia.exercise.adoption.service.AdoptionService;
import com.cambia.exercise.adoption.service.AdoptionServiceImpl;
import com.cambia.exercise.adoption.vo.PetDetails;

import junit.framework.Assert;

public class IntegerationTest {

	AdoptionService service = new AdoptionServiceImpl();
	
	/**
	 * Sanity test-case add pets in bulk and search following option 
	 * 
	 * 		search for pets in a location
	 * 		search for pets of a certain type
	 * 		search for pets of a gender
	 * 		search for pets by any combination
	 */
	@Test
	public void testSanity(){
		List<PetDetails> pets = null;
		service.addBulkPets("./src/test/resources/proper.csv");
		
		pets = service.searchPets("xx",null,null);
		Assert.assertNull(pets);
		
		pets = service.searchPets("cat", null, null);
		Assert.assertEquals(3, pets.size());
		pets = service.searchPets(null, "male", null);
		Assert.assertEquals(2, pets.size());
		pets = service.searchPets(null, null, "90210");
		Assert.assertEquals(2, pets.size());
		
		pets = service.searchPets(null,null,null);
		Assert.assertEquals(8, pets.size());
		pets = service.searchPets("cat", "female", null);
		Assert.assertEquals(1, pets.size());
		pets = service.searchPets("cat", "female", "97205");
		Assert.assertEquals(1, pets.size());
		
	}
	
	/**
	 * Test by supplying wrong data-set
	 */
	@Test
	public void testNagative(){
		
		List<PetDetails> pets = null;
		service.addBulkPets("./src/test/resources/invalid2.csv");
		
		pets = service.searchPets("dog",null,null);
		Assert.assertEquals(0, pets.size());
		
	}
}


