/**
 * 
 */
package com.arajit.crack.code.stackqueues;

/**
 * @author as47775
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
