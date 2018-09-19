package com.cambia.exercise.adoption.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cambia.exercise.adoption.vo.PetDetails;
import com.opencsv.CSVReader;

public class InputDataReader implements Reader{
	
	
	@Override
	public List<PetDetails> readPets(String filePath) {
		
		List<PetDetails> petDetails = new ArrayList<>();
		CSVReader reader = null;
		
		try {
            reader = new CSVReader(new FileReader(filePath));
            String[] line = null;
            //Skip the header
            reader.readNext();
            while ((line = reader.readNext()) != null) {
            	PetDetails pet = new PetDetails(line[0],line[1],line[2],line[3],line[4]);
            	petDetails.add(pet);
            }
        } catch (IOException e) {
            System.err.println("Invalid file :"+filePath);
        }
		return petDetails;
	}

}
