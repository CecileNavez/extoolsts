package be.abis.exa6.test;

import java.time.LocalDate;

import be.abis.exa6.model.Address;
import be.abis.exa6.model.Company;
import be.abis.exa6.model.Person;

public class ExA6 {

	public static void main(String[] args) {
		
		Address a1 = new Address("rue du marais", "10", "1000", "Brussels", "Belgium","BE");
		Company c1 = new Company("BNPPF", a1);
		Person p1 = new Person(1, "Cecile", "Navez", LocalDate.of(1974, 1, 3), c1);
	
		Person p2 = new Person(2, "Phil", "Dupont", LocalDate.of(1970, 2, 16) );
		
		System.out.println(p1.toString() + " in " + a1.getTown());
		System.out.println(p2.toString());
		
		

	}

}
