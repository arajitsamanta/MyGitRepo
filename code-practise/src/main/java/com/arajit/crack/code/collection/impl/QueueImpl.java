/**
 * 
 */
package com.arajit.crack.code.collection.impl;

import java.util.LinkedList;

/**
 * @author as47775
 * @param <E>
 * 
 */
public class QueueImpl<T> {

	private LinkedList<T> list = new LinkedList<T>();

	public void enqueue(T item) {
		list.addLast(item);
	}

	public T dequeue() {
		return list.poll();
	}

	public boolean hasItems() {
		return !list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public void addItems(QueueImpl<? extends T> q) {
		while (q.hasItems())
			list.addLast(q.dequeue());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
