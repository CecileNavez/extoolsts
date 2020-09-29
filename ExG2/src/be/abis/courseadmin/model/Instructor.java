package be.abis.courseadmin.model;

// variables
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Instructor {

	private String firstName;
	private String lastName;
	private int age;
	private int startingAge;
	private double startingSalary;
	
	public Instructor(String firstName, String lastName, int age, int startingAge, double startingSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.startingAge = startingAge;
		this.startingSalary = startingSalary;
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
	
	public int getAge() {
		return age; 
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getStartingAge() {
		return startingAge; 
	}
	
	public void setStartingAge(int startingAge) {
		this.startingAge = startingAge;
	}
	
	public double getStartingSalary() {
		return startingSalary; 
	}
	
	public void setStartingSalary(double startingSalary) {
		this.startingSalary = startingSalary;
	}
	
	//methods
	public void printSalaryHistory() throws IOException {
		
		
		BufferedWriter bw = Files.newBufferedWriter(Paths.get("salaryhistory.txt"));
		this.doPrinting(bw);
		bw.close();
		System.out.println("salaryhistory.txt created");
	
	}

	public void printSalaryHistory(String fileName) throws IOException{
		 
		 BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName));
		 this.doPrinting(bw);
		 bw.close();
		 System.out.println(fileName + " was created");
	}
	
	public void doPrinting(BufferedWriter bw) throws IOException {
		int carrierDuration = 65 - startingAge;
		
		if(carrierDuration >35) {
			carrierDuration = 35;
		}
		
		double salary = startingSalary;
		
		bw.write("Salary of " + firstName + " at " + startingAge + " is " + startingSalary + "\n");
		
		for(int i=5; i<=carrierDuration; i=i+5) {
			int salaryAge = startingAge + i ;
			salary = salary * 1.03;
			bw.write("Salary of " + firstName + " at " + salaryAge + " is " + salary + "\n");
		}
		bw.write("Maximum salary reached");
	}
		
	public String toString(){
			
			return firstName + " " + lastName + " : age is " + age + ", started at " 
			+ startingAge + " years old with first salary : " + startingSalary + " EUR" ;
		}
}
