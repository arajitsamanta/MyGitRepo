package com.arajit.crack.code.ch03.stackqueues;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class MyQueueTest {
	

	@Test
	public void queueTest() throws EmptyStackException, NoSuchElementException{
		
		MyQueue<Integer> myQueue=new MyQueue<Integer>();
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		myQueue.add(5);
		myQueue.add(6);
		assertFalse(myQueue.isEmpty());
		assertEquals(Integer.valueOf(2), myQueue.remove());
		assertEquals(Integer.valueOf(3), myQueue.remove());
		assertEquals(Integer.valueOf(4), myQueue.remove());
		assertThat(Integer.valueOf(4), is(not(myQueue.remove())));
		assertEquals(Integer.valueOf(6), myQueue.remove());
		assertTrue(myQueue.isEmpty());
		
	}
	
	
	@Test
	public void queueUsingStackTest() throws EmptyStackException, NoSuchElementException{
		
		QueueUsingStack myQueue=new QueueUsingStack();
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		myQueue.enqueue(6);
		//assertFalse(myQueue.isEmpty());
		assertEquals(Integer.valueOf(2), Integer.valueOf(myQueue.dequeue()));
		assertEquals(Integer.valueOf(3), Integer.valueOf(myQueue.dequeue()));
		assertEquals(Integer.valueOf(4), Integer.valueOf(myQueue.dequeue()));		
		assertEquals(Integer.valueOf(5), Integer.valueOf(myQueue.dequeue()));
		//assertTrue(myQueue.isEmpty());
		
	}
}
