package com.cambia.exercise.adoption.reader;

import java.util.List;

import com.cambia.exercise.adoption.vo.PetDetails;

public interface Reader {
	public List<PetDetails> readPets(String filePath) ;
}
