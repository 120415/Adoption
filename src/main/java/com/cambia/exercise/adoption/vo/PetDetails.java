package com.cambia.exercise.adoption.vo;

public class PetDetails {

	private String id;
	private String name;
	private String type;
	private String gender;
	private String zipCode;
	
	public PetDetails(String id, String name, String type, String gender, String zipCode) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.zipCode = zipCode;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getGender() {
		return gender;
	}

	public String getZipCode() {
		return zipCode;
	}
	
}
