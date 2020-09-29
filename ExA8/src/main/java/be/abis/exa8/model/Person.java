package be.abis.exa8.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	
	private int personNumber;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Company company;
	
	public Person(int personNumber, String firstName, String lastName, LocalDate birthDate) {
		super();
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public Person(int personNumber, String firstName, String lastName, LocalDate birthDate, Company company) {
		super();
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.company = company;
	}
	
	

	public int getPersonNumber() {
		return personNumber;
	}



	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public LocalDate getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}


	@Override
	public String toString(){
		
		int age = this.calculateAge();
		
		String text = "Person " + this.personNumber + " : " + this.firstName + " " + this.lastName + " (" + age + " years old)";
		if (this.company != null) {
			text += " works for " + this.company.getName() + " in " + this.company.getAddress().getTown() + ".";
	}	else {
		
		text += " is unemployed for the moment.";
	}
		
		return text;
		
	}
	
	public int calculateAge() {
		int age = Period.between(birthDate, LocalDate.now()).getYears();	
		return age;
	}
}
