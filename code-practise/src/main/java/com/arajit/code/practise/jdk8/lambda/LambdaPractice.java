package com.arajit.code.practise.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Lambda expression syntax
 * =======================
 * either
 *	(parameters) -> expression
 *	or
 *	(parameters) -> { statements; }
 *	or 
 *	() -> expression
 * 
 * Rules
 * ====
 * 1. A lambda expression can have zero, one or more parameters.
 * 2. The type of the parameters can be explicitly declared or it can be inferred from the context.
 * 3. Multiple parameters are enclosed in mandatory parentheses and separated by commas. Empty parentheses are used to represent an empty set of parameters.
 * 4. When there is a single parameter, if its type is inferred, it is not mandatory to use parentheses. e.g. a -> return a*a.
 * 5. The body of the lambda expressions can contain zero, one or more statements.
 * 6. If body of lambda expression has single statement curly brackets are not mandatory and the return type of the anonymous function is the same as that of the body expression. 
 * When there is more than one statement in body than these must be enclosed in curly brackets.
 * 
 * Functional Interface
 * ====================
 * Single Abstract Method interfaces (SAM Interfaces) is not a new concept. It means interfaces with only one single method. In java, we already have many examples of such SAM interfaces. From java 8, they will also be referred as 
 * functional interfaces as well. Java 8, enforces the rule of single responsibility by marking these interfaces with a new annotation i.e. @FunctionalInterface.
 * 
 * If you try to add a new method in any functional interface, compiler would not allow you to do this and will throw compile time error.
 *
 *
 */
public class LambdaPractice {
	
	public static void main(String[] args){
		LambdaPractice lambdaPractice=new LambdaPractice();
		
		System.out.println("****** JDK8 lambda expressions test ******");
		
	   /**
	    * Lambda expression with no parameter
	    */
	   System.out.println("-- Lambda expression with no parameter");
	   Sayable s=()->{  
	        return "I have nothing to say.";  
	    };  
	    System.out.println(s.say());
	    
	    /**
	     * Lambda expression with single parameter.  
	     */
	    System.out.println("-- Lambda expression with single parameter");
	    Sayable2 s2=(name)->{  
            return "Hello, "+name;  
        };  
        System.out.println(s2.say("Sonoo"));  
        
        /**
	     * Lambda expression with single parameter(without parentheses)  
	     */
        System.out.println("-- Lambda expression with single parameter(without parentheses)");
        // You can omit function parentheses    
        Sayable2 s3= name ->{  
            return "Hello, "+name;  
        };  
        System.out.println(s3.say("Sonoo"));  
        
        /**
         *  Multiple parameters in lambda expression 
         */
        System.out.println("-- Multiple parameters in lambda expression"); 
        MathOperation addition = (int a,int b) -> {
        	return (a+b);
        };  
        System.out.println(lambdaPractice.operate(10, 20, addition));  
        
        /**
         *  You can pass multiple statements in lambda expression  
         */
        System.out.println("-- Multiple statements in lambda expression"); 
        Sayable2 person = (message)-> {  
            String str1 = "I would like to say, ";  
            String str2 = str1 + message;   
            return str2;  
        };  
        System.out.println(person.say("time is precious."));  
        
		/**
		 *  Print an array using lambda
		 */
		String[] strArr = { "ab", "cd", "ef" };
		System.out.println("-- forEach,  Print an array");
		Arrays.stream(strArr).forEach(System.out::println);

		/**
		 *  Iterating over an List and perform some operation
		 */
		List<Integer> pointList = new ArrayList<Integer>();
		pointList.add(1);
		pointList.add(2);
		pointList.add(25);

		/**
		 *  Print all element of a list
		 */
		System.out.println("-- forEach, Print all element of a list");
		pointList.forEach(p -> {
			System.out.println(p);
		});

		/**
		 *  Sum all elements of a list
		 */
		System.out.println("-- Sum all elements of a list");
		int sum = pointList.parallelStream().reduce(0, Integer::sum);
		System.out.println(sum);

		/**
		 *  Create a new runnable and pass it to thread
		 */
		System.out.println("-- Create a new runnable and pass it to thread");
		new Thread(() -> System.out.println("My Runnable")).start();

        /**
         * Sort Array of objects by their name using lambda
         */
      	Employee[] employees  = {
      	              new Employee("David"),
      	              new Employee("Naveen"),
      	              new Employee("Alex"),
      	              new Employee("Richard")};
      	            
      	  
      	Arrays.sort(employees, Employee::nameCompare);
      	System.out.println("-- Sort Array of objects by lambda ");
      	System.out.println(Arrays.toString(employees));
      	
      	/**
      	 *  Comparator: Lambda expression
      	 */
      	List<Product> list=new ArrayList<Product>();  
        
        //Adding Products  
        list.add(new Product(1,"HP Laptop",25000f));  
        list.add(new Product(3,"Keyboard",300f));  
        list.add(new Product(2,"Dell Mouse",150f));  
               
        // Implementing lambda expression  
        Collections.sort(list,(p1,p2)->{  
        	return p1.name.compareTo(p2.name);  
        });  
        System.out.println("-- Sort list of objects by lambda ");
        list.forEach(p->{
        	  System.out.println(p.id+" "+p.name+" "+p.price);  
        });
        
        
        /**
         *Filter collection data using lambda
         */ 
        Stream<Product> filteredProduct = list.stream().filter(p -> p.price > 20000);   
        System.out.println("-- Filter collection data using lambda");
        filteredProduct.forEach(
        		product -> System.out.println(product.name+":"+product.price)
        );
        
	}
	
	private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	}
	
}

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
} 

class Employee {
	String name;

	Employee(String name) {
		this.name = name;
	}

	public static int nameCompare(Employee a1, Employee a2) {
		return a1.name.compareTo(a2.name);
	}

	public String toString() {
		return name;
	}
}

@FunctionalInterface
interface Sayable{  
    public String say();  
} 

@FunctionalInterface
interface Sayable2{  
    public String say(String str);  
} 

@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
 }