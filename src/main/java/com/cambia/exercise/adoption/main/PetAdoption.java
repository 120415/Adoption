package com.cambia.exercise.adoption.main;

import java.util.List;
import java.util.Scanner;

import com.cambia.exercise.adoption.service.AdoptionService;
import com.cambia.exercise.adoption.service.AdoptionServiceImpl;
import com.cambia.exercise.adoption.vo.PetDetails;

public class PetAdoption {
	
	private AdoptionService  adoptionService  = new AdoptionServiceImpl();
	
	public void addPets(String filePath){
		adoptionService.addBulkPets(filePath);
	}
	
	public void search(String type, String gender, String location){
		List<PetDetails> pets = adoptionService.searchPets(type, gender, location);
		for(PetDetails pet : pets){
			System.out.println("ID:"+pet.getId()+", Name:"+pet.getName()+", Type:"+pet.getType()+", Gender:"+pet.getGender()+", ZipCode:"+pet.getZipCode());
		}
	}
	
	public void displayOptions(){
		System.out.println("Please choose any following options");
		System.out.println(" Type 1 for add pets");
		System.out.println(" Type 2 for search pets");
		System.out.println(" Type 3 for exit");
	}
	
	
	public static void main(String[] args) {
		
		PetAdoption adoptionMain = new PetAdoption();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			adoptionMain.displayOptions();
			int option = scanner.nextInt();
			if(option == 3){
				scanner.close();
				break;
			}else if(option == 1){
				System.out.println("Please enter input file path");
				String filePath = scanner.next();
				adoptionMain.addPets(filePath);
			}else if(option == 2){
				scanner.nextLine();
				System.out.println("Please enter location details or Press Enter to Skip");
				String location = scanner.nextLine();
				System.out.println("Please enter pet type or Press Enter to Skip");
				String type = scanner.nextLine();
				System.out.println("Please enter gender or Press Enter to Skip");
				String gender = scanner.nextLine();
				adoptionMain.search(type, gender, location);
			}else{
				System.out.println("Invalid options");
			}
		}
		
	}

}
