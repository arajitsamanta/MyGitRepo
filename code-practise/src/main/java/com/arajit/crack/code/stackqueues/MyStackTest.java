/**
 * 
 */
package com.arajit.crack.code.stackqueues;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author as47775
 *
 */
public class MyStackTest {
	
	@Test
	public void stackTest() throws EmptyStackException{
		MyStack<Integer> myStack=new MyStack<Integer>();
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);		
		assertEquals(Integer.valueOf(5), myStack.pop());
		assertEquals(Integer.valueOf(4), myStack.peek());
		myStack.push(6);	
		assertEquals(Integer.valueOf(6), myStack.peek());
		assertEquals(Integer.valueOf(6), myStack.pop());
	}
	
	@Test
	public void stackWidMinTest() throws EmptyStackException{
		StackWithMin myStackMin=new StackWithMin();
		myStackMin.push(5);
		myStackMin.push(6);
		myStackMin.push(3);
		myStackMin.push(8);
		assertEquals(3,myStackMin.min());
		myStackMin.pop();
		myStackMin.pop();
		assertEquals(5,myStackMin.min());
	}
	
	
}
