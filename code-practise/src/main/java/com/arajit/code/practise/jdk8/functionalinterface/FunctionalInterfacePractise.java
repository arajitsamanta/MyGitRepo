/**
 * 
 */
package com.arajit.code.practise.jdk8.functionalinterface;

import java.util.Arrays;

/**
 * @author as47775
 * 
 * Functional interfaces are new additions in java 8 which permit exactly one abstract method inside them. These interfaces are also called Single Abstract Method interfaces (SAM Interfaces). 
 * These can be represented using Lambda expressions, Method reference and constructor references as well. Java 8 introduces an annotation i.e. @FunctionalInterface too, which can be used 
 * for compiler level errors when the interface you have annotated violates the contracts of Functional Interface.
 * 
 * 1. Only one abstract method is allowed in any functional interface.
 * 2. A functional interface is valid even if the @FunctionalInterface annotation would be omitted. It is only for informing the compiler to enforce single abstract method inside interface
 * 3. 
 */
public class FunctionalInterfacePractise implements MyFuncInterface{
	
	public static void main(String[] args){
		System.out.println();
		
		FunctionalInterfacePractise myFuncInterface=new FunctionalInterfacePractise();
		
		myFuncInterface.work();
		
		myFuncInterface.defaultWork();
		
		
		
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("I am working");
	}
	
	
}

@FunctionalInterface
interface MyFuncInterface{
	
	public void work();
	
	default void defaultWork(){
		/*(String s) -> {
			System.out.println(s);
		}*/
		
		System.out.println("I am default work");
		
		String names[]={"abc","xyz"};
		
		Arrays.sort(names, (o1, o2) -> 0);
		
		Arrays.sort(names,String::compareTo);
	}
	
}