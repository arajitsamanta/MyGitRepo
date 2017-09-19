/**
 * 
 */
package com.arajit.crack.code.ch03.stackqueues;

/**
 * @author as47775
 * 
 * How would you design a stack, which in addition to push and pop it will have min() method which will always return minimum element in stack.
 * 
 * Note that push/pop/min need to work O(1) constant time.
 *
 */
public class StackWithMin extends MyStack<Integer> {
	
	MyStack<Integer> s2;
	
	public StackWithMin(){
		s2=new MyStack<Integer>();
	}
	
	public void push(int value) throws EmptyStackException{
		if(value<=min()){
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() throws EmptyStackException{
		int value=super.pop();
		if(value == min()){
			s2.pop();
		}
		return value;
	}
	
	public int min() throws EmptyStackException{
		if(s2.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return s2.peek();
		}
	}
	
}
