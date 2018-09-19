package com.cambia.exercise.adoption.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cambia.exercise.adoption.common.AdoptionConstant;
import com.cambia.exercise.adoption.vo.PetDetails;


public enum SimpleCache {

	INSTANCE;
	
	Map<Key,List<PetDetails>> dataCache = new HashMap<>();
	
	public void addPets(List<PetDetails> pets){
		
		for(PetDetails value : pets){
			Key key = new Key(value.getZipCode(), value.getType(), value.getGender());
			addPets(key, value);
		}
	}
	
	public List<PetDetails> search(String type, String gender, String location){
		
		if(type == null || type.trim().length() == 0)
			type = AdoptionConstant.ANY;
		if(gender == null || gender.trim().length() == 0 )
			gender = AdoptionConstant.ANY;
		if(location == null || location.trim().length() == 0)
			location = AdoptionConstant.ANY;
		
		Key searchKey = new Key(location,type, gender);
		return search(searchKey);
	}
	
	private void addPets(Key key, PetDetails value){
		
		if(dataCache.containsKey(key)){
			dataCache.get(key).add(value);
		}else{
			List<PetDetails> pets = new ArrayList<>();
			pets.add(value);
			dataCache.put(key, pets);
		}
	}
	
	private List<PetDetails> search(Key key){
		
		List<PetDetails> listOfAnimal = new ArrayList<>();
		for(Entry<Key,List<PetDetails>> entry : dataCache.entrySet()){
			
			Key entryKey = entry.getKey();
			if(!key.getGender().equalsIgnoreCase(AdoptionConstant.ANY) && !entryKey.getGender().equalsIgnoreCase(key.getGender())){
				continue;
			}
			if(!key.getZipCode().equalsIgnoreCase(AdoptionConstant.ANY) && !entryKey.getZipCode().equalsIgnoreCase(key.getZipCode())){
				continue;
			}
			if(!key.getType().equalsIgnoreCase(AdoptionConstant.ANY) && !entryKey.getType().equalsIgnoreCase(key.getType())){
				continue;
			}
			listOfAnimal.addAll(entry.getValue());
		}
		return listOfAnimal;
	}
	
}
