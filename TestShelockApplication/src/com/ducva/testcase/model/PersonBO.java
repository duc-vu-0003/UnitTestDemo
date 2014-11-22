package com.ducva.testcase.model;

public class PersonBO {
	int personID;
	String personName;
	boolean personGender;
	int personHeight;
	int personAge;
	String personAddress;
	String personHairColor;
	String additionalcomment;
	String images;
	
	public PersonBO(){
		
	}
	
	public PersonBO(String personName, boolean personGender, int personHeight, int personAge, String personAddress, String personHairColor, String additionalcomment,String images){
		this.personName = personName;
		this.personGender = personGender;
		this.personHeight = personHeight;
		this.personAge = personAge;
		this.personAddress = personAddress;
		this.personHairColor = personHairColor;
		this.additionalcomment = additionalcomment;
		this.images = images;
	}
	
	public PersonBO(int personID, String personName, boolean personGender, int personHeight, int personAge, String personAddress, String personHairColor, String additionalcomment,String images){
		this.personID = personID;
		this.personName = personName;
		this.personGender = personGender;
		this.personHeight = personHeight;
		this.personAge = personAge;
		this.personAddress = personAddress;
		this.personHairColor = personHairColor;
		this.additionalcomment = additionalcomment;
		this.images = images;
	}
	
	public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public boolean isPersonGender() {
        return personGender;
    }

    public void setPersonGender(boolean personGender) {
        this.personGender = personGender;
    }

    public int getPersonHeight() {
        return personHeight;
    }

    public void setPersonHeight(int personHeight) {
        this.personHeight = personHeight;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonHairColor() {
        return personHairColor;
    }

    public void setPersonHairColor(String personHairColor) {
        this.personHairColor = personHairColor;
    }

    public String getAdditionalcomment() {
        return additionalcomment;
    }

    public void setAdditionalcomment(String additionalcomment) {
        this.additionalcomment = additionalcomment;
    }
    
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
