package com.cambia.exercise.adoption.cache;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.cambia.exercise.adoption.vo.PetDetails;

import junit.framework.Assert;

public class SimpleCacheTest {

	@Test
	public void testAddPets(){
		
		List<PetDetails> pets = new ArrayList<>();
		PetDetails mock1 = Mockito.mock(PetDetails.class);
		Mockito.when(mock1.getGender()).thenReturn("Male");
		Mockito.when(mock1.getType()).thenReturn("DOG");
		Mockito.when(mock1.getZipCode()).thenReturn("94083");
		Mockito.when(mock1.getName()).thenReturn("A");
		pets.add(mock1);
		
		PetDetails mock2 = Mockito.mock(PetDetails.class);
		Mockito.when(mock2.getGender()).thenReturn("Male");
		Mockito.when(mock2.getType()).thenReturn("CAT");
		Mockito.when(mock2.getZipCode()).thenReturn("94082");
		Mockito.when(mock2.getName()).thenReturn("B");
		pets.add(mock2);
		
		SimpleCache.INSTANCE.addPets(pets);
		
		
		List<PetDetails> result = SimpleCache.INSTANCE.search("DOG", null, null);
		Assert.assertEquals(1, result.size());
		
		result = SimpleCache.INSTANCE.search("CAT", null, null);
		Assert.assertEquals(1, result.size());
		
		result = SimpleCache.INSTANCE.search(null, "Male", null);
		Assert.assertEquals(2, result.size());
		
		result = SimpleCache.INSTANCE.search(null, null, "94082");
		Assert.assertEquals(1, result.size());
		
		result = SimpleCache.INSTANCE.search(null, null, null);
		Assert.assertEquals(2, result.size());
		
	}
}
