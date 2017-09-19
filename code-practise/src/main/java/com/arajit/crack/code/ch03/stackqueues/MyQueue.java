package com.arajit.crack.code.ch03.stackqueues;

public class MyQueue<T> {

	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T item) {
		QueueNode<T> qnode = new QueueNode<T>(item);
		if (last != null) {
			last.next = qnode;
		}
		last = qnode;
		if (first == null)
			first = last;
	}

	public T remove() throws NoSuchElementException {
		if (first == null)
			throw new NoSuchElementException();
		T item = first.data;
		first = first.next;
		if (first == null)
			last = null;
		return item;
	}

	public T peek() throws NoSuchElementException {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	boolean isEmpty() {
		return first == null;
	}
}
