package com.cambia.exercise.adoption.validator;

import com.cambia.exercise.adoption.common.AdoptionConstant.Gender;
import com.cambia.exercise.adoption.common.AdoptionConstant.Type;

public class PetDataValidator implements Validator{
	
	private final Integer zipCodeSize = 5;

	@Override
	public boolean validateType(String data) {
		if(data != null && data.trim().length() != 0){
			for(Type type : Type.values()){
				if(type.name().equalsIgnoreCase(data)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean validateGender(String data) {
		if(data != null && data.trim().length() != 0){
			for(Gender gender : Gender.values()){
				if(gender.name().equalsIgnoreCase(data)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean validateZipCode(String data) {
		if(data != null && data.trim().length() != 0 && data.length() == zipCodeSize && data.matches("\\d+")){
			return true;
		}
		return false;
	}

	@Override
	public boolean validateName(String data) {
		if(data != null  && data.trim().length() != 0 && data.matches("^[a-zA-Z]+$")){
			return true;
		}
		return false;
	}

	@Override
	public boolean validateId(String data) {
		if(data != null  && data.trim().length() != 0 && data.matches("\\d+")){
			return true;
		}
		return false;
	}

}
