/**
 * 
 */
package com.arajit.crack.code.ch01.arraysandstrings;

import org.junit.Test;

/**
 * @author as47775
 * 
 * Problem:
 * Based on a traditional English children's game
 * Print the numbers 1..100
 * For multiples of 5, print "Fizz" instead of the number
 * For multiples of 7, print "Buzz" instead of the number
 * For multiples of 5 and 7, print "FizzBuzz" instead of the number
 * else print original no.
 */
public class FizzBuzzGame {

	public void fizzBuzz(){
		
		for(int i=0;i<=100;i++){
			
			if(i%5 ==0 & i%7 ==0){
				System.out.println("FizzBuzz");
			}else if(i%5==0){
				System.out.println("Fizz");
			}else if(i%7==0){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}
			System.out.println();
		}
		
	}
	
	@Test
	public void fizzBuzzTest(){
		fizzBuzz();		
	}

}
