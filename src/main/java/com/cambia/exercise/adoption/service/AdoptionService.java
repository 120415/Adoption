package com.cambia.exercise.adoption.service;

import java.util.List;

import com.cambia.exercise.adoption.vo.PetDetails;

public interface AdoptionService {

	public void addBulkPets(String filePath);
	public List<PetDetails> searchPets(String type, String gender, String location);
}
