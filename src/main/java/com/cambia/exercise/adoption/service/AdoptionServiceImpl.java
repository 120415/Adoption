package com.cambia.exercise.adoption.service;

import java.util.List;

import com.cambia.exercise.adoption.cache.SimpleCache;
import com.cambia.exercise.adoption.reader.InputDataReader;
import com.cambia.exercise.adoption.reader.Reader;
import com.cambia.exercise.adoption.validator.ValidatorFacade;
import com.cambia.exercise.adoption.vo.PetDetails;

public class AdoptionServiceImpl implements AdoptionService{

	@Override
	public void addBulkPets(String filePath) {
		List<PetDetails> pets = null;
		try{
			Reader reader = new InputDataReader();
			pets = reader.readPets(filePath);
		}catch (RuntimeException exception) {
	        System.err.println("Failed to read data from :"+filePath+" Please verify");
	    }
		
		boolean isValid = ValidatorFacade.INSTANCE.validatePets(pets);
		
		if(isValid){
			SimpleCache.INSTANCE.addPets(pets);
		}else{
			System.err.println("Due to invalid data, Not able to add into Cache");
		}
	}

	@Override
	public List<PetDetails> searchPets(String type, String gender, String location) {
		List<PetDetails> pets = null;
		boolean isValid = ValidatorFacade.INSTANCE.validateSearchKey(location,gender,type);
		if(isValid){
			pets = SimpleCache.INSTANCE.search(type, gender, location);
		}else{
			System.err.println("Invalid search key");
		}
		
		return pets;
	}

}
