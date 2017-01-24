package com.arajit.crack.code.stackqueues;

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
}
