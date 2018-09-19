package com.cambia.exercise.adoption.validator;

import java.util.List;

import com.cambia.exercise.adoption.vo.PetDetails;

public enum ValidatorFacade {
	
	INSTANCE;
	
	private Validator validator = new PetDataValidator();
	
	public boolean validatePets(List<PetDetails> pets){
		
		for(PetDetails pet : pets){
			if( !(validator.validateGender(pet.getGender()) && 
			validator.validateId(pet.getId()) &&
			validator.validateName(pet.getName()) &&
			validator.validateType(pet.getType()) &&
			validator.validateZipCode(pet.getZipCode()))){
				
				System.out.println("Worng Data Set :: Id : "+pet.getId()+", Name : "+pet.getName()+", Type :"+
						pet.getType()+", Gender :"+pet.getGender()+", ZipCode : "+pet.getZipCode());
				return false;
			}
		}
		return true;
	}
	
	public boolean validateSearchKey(String zipCode, String gender, String type){
		if(gender != null && gender.trim().length() != 0 && !validator.validateGender(gender)){
			System.out.println("Invalid search key Gender :"+gender);
			return false;
		}
		if(type != null && type.trim().length() != 0 && !validator.validateType(type)){
			System.out.println("Invalid search key Type :"+ type);
			return false;
		}if(zipCode != null && zipCode.trim().length() !=0 && !validator.validateZipCode(zipCode)){
			System.out.println("Invalid search key ZipCode : "+zipCode);
			return false;
		}
		return true;
	}	
	
}
