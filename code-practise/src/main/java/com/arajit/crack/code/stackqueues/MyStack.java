package com.arajit.crack.code.stackqueues;

public class MyStack<T> {

	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;

	T pop() throws EmptyStackException {
		if (top == null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}

	public T peek() throws EmptyStackException {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
