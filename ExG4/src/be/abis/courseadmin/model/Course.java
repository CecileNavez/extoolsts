package be.abis.courseadmin.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class Course{
	// Variables
	
	private String title;
	private int numberOfDays;
	private double pricePerDay;
	private boolean priorKnowledgeRequired;
	private ArrayList<Instructor> instructors = new ArrayList<>();
	
	public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeRequired) {
		this.title = title;
		this.numberOfDays = numberOfDays;
		this.pricePerDay = pricePerDay;
		this.priorKnowledgeRequired = priorKnowledgeRequired;
	}

	// gets and sets

	public String getTitle() {
		return title; 
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getNumberOfDays() {
		return numberOfDays; 
	}
	
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	public double getPricePerDay() {
		return pricePerDay; 
	}
	
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public boolean getPriorKnowledgeRequired() {
		return priorKnowledgeRequired; 
	}
	
	public void setPriorKnowledgeRequired(boolean priorKnowledgeRequired) {
		this.priorKnowledgeRequired = priorKnowledgeRequired;
	}
	
	public void setInstructors(ArrayList<Instructor> instructors){
		this.instructors=instructors;
	}
	
	public ArrayList<Instructor> getInstructors(){
		return instructors;
	}
	
	//methods
	
	public void addInstructor(Instructor instructor){
		instructors.add(instructor);
	}
	
	public void removeInstructor(Instructor instructor){
		instructors.remove(instructor);
	}
	
	public void printInfo() throws IOException{
	   BufferedWriter bw = Files.newBufferedWriter(Paths.get("printing.txt"));
	   double totalPrice = this.calculatePrice();
	   bw.write(
				"The title of the course is '" + title + "'.\n" +
				"The course duration is " + numberOfDays + " days.\n" +
				"The price per day is " + pricePerDay + " EUR.\n" +
				"It is " + priorKnowledgeRequired + " to think that you need prerequisite to follow the course.\n" +
				"The total price of the course is " + totalPrice + " EUR.\n"
				);
	 
	   
		String courseLabel;
		if (totalPrice < 500) {
			courseLabel = "CHEAP";
		} else if (totalPrice >= 500 &&  totalPrice <= 1500) {
			courseLabel = "OK";
		} else {
		courseLabel = "EXPENSIVE";
		}
		bw.write("The price is " + courseLabel + "\n");
		bw.write("There are (is) " + instructors.size() + " instructor(s) for this course \n");
		bw.write("The instructors are :\n");
		for (Instructor i: instructors) {
			bw.write(i.toString()+"\n");
		}
		
	   bw.close();
	}
	
	public double calculatePrice(){
		double totalPrice = numberOfDays*pricePerDay;
		if (!(numberOfDays>3 && priorKnowledgeRequired)) {
			totalPrice*=1.21;
		}
		return totalPrice; 
	}
	
	
	
}