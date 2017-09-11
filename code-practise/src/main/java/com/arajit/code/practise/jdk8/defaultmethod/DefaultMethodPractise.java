/**
 * 
 */
package com.arajit.code.practise.jdk8.defaultmethod;

/**
 * @author as47775
 *
 * 1. Default methods in java 8 are simply default. If you do not override them, they are the methods which will be invoked by caller classes. They are defined in interfaces.
 * 2. If any derive class willingly wants to customize the behavior then it can provide it's own custom implementation and override the method
 * 3. Static default methods: You can define static default methods in interface which will be available to all instances of class which implement this interface. This makes it easier for 
 *    you to organize helper methods in your libraries; you can keep static methods specific to an interface in the same interface rather than in a separate class. 
 *    This enables you to define methods out of your class and yet share with all child classes.
 * 4. They provide you an highly desired capability of adding a capability to number of classes without even touching their code. Simply add a default method in interface which they all implement.
 */
public class DefaultMethodPractise implements Movable{
	
	public static void main(String[] args){
		
		/**
		 * Instance default method
		 */
		DefaultMethodPractise movable=new DefaultMethodPractise(); 
		movable.move();
		
		/**
		 * Static default method
		 */
		MovableStatic.move();
	}
	
}

interface Movable{
	
	default void move(){
        System.out.println("By default, I am  moving!!");
    }
	
}

interface MovableStatic{
	
	static void move(){
        System.out.println("I am  moving statically!!");
    }
	
}