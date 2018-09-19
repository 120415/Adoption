package com.cambia.exercise.adoption.validator;

public interface Validator {
	
	public boolean validateType(String data);
	public boolean validateGender(String data);
	public boolean validateZipCode(String data);
	public boolean validateName(String data);
	public boolean validateId(String data);
}
