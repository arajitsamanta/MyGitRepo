package com.arajit.code.practise.jdk8.optional;

import java.util.Optional;

/**
 * 
 * @author as47775
 *
 * A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.
 * Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (return a default value if value not present) and ifPresent() 
 * (execute a block of code if the value is present).
 *
 * This is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash code, or synchronization) on instances of Optional may have 
 * unpredictable results and should be avoided.
 */
public class OptionalPractise {

	public static void main(String[] args){
		
		/**
		 *  Use Optional.empty to create an Optional
		 */
		Optional<Integer> canBeEmpty2 = Optional.empty();
		System.out.println(canBeEmpty2.isPresent());      // returns false
		
				
		/**
		 * Use Optional.of() to create optional with default non-null value. If you pass null in of(), then a NullPointerException is thrown immediately.
		 */
		Optional<Integer> canBeEmpty1 = Optional.of(5);
		canBeEmpty1.isPresent();                    // returns true
		System.out.println(canBeEmpty1.get());      // returns 5
		 
		/** Use Optional.ofNullable() to create an Optional object that may hold a null value. If parameter is null, the resulting Optional object would be empty
		 * (remember that value is absent; don't read it null).
		 */
		Optional<Integer> possible = Optional.ofNullable(null); 
		System.out.println(possible.isPresent());
		
		//or
		Optional<Integer> possible2 = Optional.ofNullable(5);
		System.out.println(possible2.isPresent());
		
		/**
		 * Do something If Optional value is present
		 */
		Optional<Integer> possible1 = Optional.of(5); 
		possible1.ifPresent(System.out::println);
		
		/**
		 * Default/absent values and actions
		 */
		Optional<Company> companyOptional = Optional.empty();
		
		/*ArrayList<Company> companyList=new ArrayList<Company>();
		
		Company comp1=new Company();
		comp1.setDepartment("Finance");
		
		companyList.add(comp1);
		Optional<Company> companyOptional = Optional.of(companyList.stream().);*/
		
		/** Now check optional; if value is present then return it, 
		 *  else create a new Company object and return it
		 */
		Company company = companyOptional.orElse(new Company());
		company.setDepartment("Finance");
		
		/**
		 * OR you can throw an exception as well
		 */
		//Company companyError = companyOptional.orElseThrow(IllegalStateException::new);
		
		
		/**
		 * Rejecting certain values using the filter method
		 */
		companyOptional.filter(department -> "Finance".equals(department.getName())).ifPresent((x) -> System.out.println("Finance is present"));
		//companyOptional.filter(predicate)
		// if the value is not present
		Optional<Product> carOptionalEmpty = Optional.empty();
		carOptionalEmpty.filter(x -> "250".equals(x.getPrice()))
				.ifPresent(x -> System.out.println(x.getPrice() + " is ok!"));
		
		 System.out.println("boolean:"+Boolean.valueOf(null));
	}
}

class Product{
	
	int price;
	
	public int getPrice(){
		return price;
	}
}

class Company {
	
	String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Object getName() {
		return department;
	}
	
}


