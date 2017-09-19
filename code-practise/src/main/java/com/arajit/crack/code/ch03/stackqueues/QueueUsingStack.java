/**
 * 
 */
package com.arajit.crack.code.ch03.stackqueues;

/**
 * @author as47775
 *	
 *  Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueUsingStack {
	
	MyStack<Integer> newestStack,oldestStack;
	
	QueueUsingStack(){
		newestStack=new MyStack<Integer>();
		oldestStack=new MyStack<Integer>();
	}
	
	public int size() {
		 return newestStack.size() + oldestStack.size();
    }
	
	/* Push onto stackNewest, which always has the newest elements on top */
	public void enqueue(int item){
		newestStack.push(item);
	}
	
	public int dequeue() throws EmptyStackException{
		shiftStack(); // Ensure stackOldest has the current elements
		return oldestStack.pop(); // pop the oldest item.
	}
	
	public int peek() throws EmptyStackException {
		shiftStack(); // Ensure stackOldest has the current elements
		return oldestStack.peek(); // retrieve the oldest item.
	}
	
	/** Move elements from stackNewest into stackOldest. This is usually done so that we can do operations on stackOldest. 
	 * 
	 */
	private void shiftStack() throws EmptyStackException{
		if(oldestStack.isEmpty()){
			while(!newestStack.isEmpty()){
				oldestStack.push(newestStack.pop());
			}
		}
	}
	
}
