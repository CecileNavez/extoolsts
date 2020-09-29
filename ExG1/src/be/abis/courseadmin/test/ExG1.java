package be.abis.courseadmin.test;

import java.io.IOException;

import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class ExG1 {

	public static void main(String[] args) {
			
		try {
			Instructor instr1 = new Instructor("Cecile", "Navez", 46, 27, 3000.0);
			instr1.printSalaryHistory("cecile.txt"); // dans fichier cecile.txt
			
			Instructor instr2 = new Instructor("Philippe", "Dupont", 50, 20, 1500.0);
			instr2.printSalaryHistory(); // dans salaryhistory.txt
			
			boolean priorknowledge = true;
			Course myCourse = new Course("Java Training", 5, 735.30, priorknowledge);
			myCourse.addInstructor(instr1);
			myCourse.addInstructor(instr2);
			
			myCourse.printInfo();
						
			
			System.out.println("Infos printed in files printing.txt and salaryhistory.txt" );
		
		} catch (NumberFormatException e) {
			 System.out.println("Insert correct argument, try again");
			 
		}  catch (IOException ioe){
			  System.out.println(ioe.getMessage());
		 }
		 
	}
}
