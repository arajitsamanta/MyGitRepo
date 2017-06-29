package com.arajit.code.practise.jdk8.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * @author as47775
 * 
 * METHOD REFERENCE										DESCRIPTION																		EXAMPLE
 * Reference to static method							Used to refer static methods from a class										Math::max equivalent to Math.max(x,y)
 * Reference to instance method from instance			Refer to an instance method using a reference to the supplied object			System.out::println equivalent to System.out.println(x)
 * Reference to instance method from class type			Invoke the instance method on a reference to an object supplied by the context	String::length equivalent to str.length()
 * Reference to constructor								Reference to a constructor														ArrayList::new equivalent to new ArrayList()
 *
 */
public class MethodReferencePractise {
	
	public static void main(String[] args){
		
		System.out.println("****** JDK8 method reference test ******");
		
		/**
		 * Reference to static method – Class::staticMethodName
		 */
		List<Integer> integers = Arrays.asList(1,12,433,5);		
		Optional<Integer> max = integers.stream().reduce( Math::max );
		System.out.println("-- Reference to static method – Class::staticMethodName");
		max.ifPresent(value -> System.out.println(value)); 
		
		// Referring static method
        Sayable sayable = MethodReferencePractise::saySomething;  
        // Calling interface method  
        sayable.say();
        
        // Here we are using predefined functional interface Runnable to refer static method. 
        Thread t2=new Thread(MethodReferencePractise::ThreadStatus);  
        t2.start();   
        
        // You can also use predefined functional interface to refer methods. In the following example, we are using BiFunction interface and using it's apply() method.
        BiFunction<Integer, Integer, Integer>adder = Arithmetic::add;  
		int result = adder.apply(10, 20);  
		System.out.println(result);  
		
		// You can also override static methods by referring methods. In the following example, we have defined and overloaded three add methods.
		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;  
		BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;  
		BiFunction<Float, Float, Float> adder3 = Arithmetic::add;  
		int result1 = adder1.apply(10, 20);  
		float result2 = adder2.apply(10, 20.0f);  
		float result3 = adder3.apply(10.0f, 20.0f);  
		System.out.println(result1);  
		System.out.println(result2);  
		System.out.println(result3);  
		
		/**
		 * Reference to instance method from instance – ClassInstance::instanceMethodName
		 */
		System.out.println("-- Reference to static method – ClassInstance::staticMethodName");
		max.ifPresent(System.out::println);
		
		MethodReferencePractise methodReference = new MethodReferencePractise(); // Creating object
		// Referring non-static method using reference
		Sayable sayableNonStatic = methodReference::saySomethingNonStatic;
		// Calling interface method
		sayableNonStatic.say();
		// Referring non-static method using anonymous object
		Sayable sayable2 = new MethodReferencePractise()::saySomethingNonStatic; // You can use anonymous object also
		// Calling interface method
		sayable2.say();
		
		// In the following example, we are referring instance (non-static) method. Runnable interface contains only one abstract method. So, we can use it as functional interface.
		Thread t3=new Thread(new MethodReferencePractise()::printnMsg);  
		t3.start();       
		
		// In the following example, we are using BiFunction interface. It is a predefined interface and contains a functional method apply(). Here, we are referring add method to apply method.
		BiFunction<Integer, Integer, Integer> adderNonStatic = new Arithmetic()::addNonStatic;  
		int resultNonStatic = adderNonStatic.apply(10, 20);  
		System.out.println(resultNonStatic);  
		
		/**
		 * Reference to instance method from class type - Class::instanceMethodName
		 */
		List<String> strings = Arrays
		        .asList("how", "to", "do", "in", "java", "dot", "com");
		 
		List<String> sorted = strings
		        .stream()
		        .sorted((s1, s2) -> s1.compareTo(s2))
		        .collect(Collectors.toList());
		 
		List<String> sortedAlt = strings
		        .stream()
		        .sorted(String::compareTo)
		        .collect(Collectors.toList());
		System.out.println("-- Reference to instance method from class type - Class::instanceMethodName");
		System.out.println(sorted);
		System.out.println(sortedAlt);
		
		
		/**
		 *  Reference to constructor – Class::new
		 */
		List<Integer> integersList = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toCollection( ArrayList::new ));
 
		Optional<Integer> maxInt = integersList.stream().reduce(Math::max); 
		System.out.println("-- Reference to constructor – Class::new"); 
		maxInt.ifPresent(System.out::println); 
		
		Messageable hello = Message::new;  
        hello.getMessage("Hello");  
	}
	
	public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    } 
	
	public void saySomethingNonStatic(){  
        System.out.println("Hello, this is not static method.");  
    } 
	
	public static void ThreadStatus(){  
        System.out.println("Thread is running...");  
    }  
	
	public void printnMsg(){  
	     System.out.println("Hello, this is instance method");  
	}
	
	
}

@FunctionalInterface
interface Sayable{  
    void say();  
}  

class Arithmetic{  
	public static int add(int a, int b){  
		return a+b;  
	}
	
	public int addNonStatic(int a, int b){  
		return a+b;  
	}
	
	public static float add(int a, float b) {
		return a + b;
	}

	public static float add(float a, float b) {
		return a + b;
	}
}  

@FunctionalInterface
interface Messageable{  
    Message getMessage(String msg);  
}

class Message{  
    public Message(String msg){  
        System.out.print(msg);  
    }  
}  
