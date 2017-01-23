/**
 * 
 */
package com.arajit.crack.code.collection.impl;

/**
 * @author as47775
 *
 */
public class StackImpl {
	
	private int[] stackArray;
	private int maxSize;
	int top=-1;
	
	/**
	 * 
	 */
	public StackImpl(int size) {
		stackArray=new int[size];
		maxSize=size;		
	}
	
	public void push(int element){
		stackArray[++top]=element;		
	}
	
	public int pop(){
		return stackArray[top--];		
	}
	
	public int peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top==-1); 
	}
	
	public boolean isFull(){
		return (top==maxSize-1); 
	}
	
	public static void main(String[] args){
		  StackImpl theStack = new StackImpl(10); 
	      theStack.push(10);
	      theStack.push(20);
	      theStack.push(30);
	      theStack.push(40);
	      theStack.push(50);
	      while (!theStack.isEmpty()) {
	         long value = theStack.pop();
	         System.out.print(value);
	         System.out.print(" ");
	      }
	      System.out.println("");
	}
}
