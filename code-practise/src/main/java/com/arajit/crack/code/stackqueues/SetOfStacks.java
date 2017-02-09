/**
 * 
 */
package com.arajit.crack.code.stackqueues;

import java.util.ArrayList;
import java.util.List;

/**
 * @author as47775 
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start
 * a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity. SetOfStacks. push() and SetOfStacks.
 *         
 * pop() should behave identically to a single stack (that is, pop () should return the same values as it would if there were just a single stack). 
 *  
 * FOLLOW UP Implement a function popAt(int index) which performs a pop operation on a specific substack.
 *
 */
@SuppressWarnings("rawtypes")
public class SetOfStacks {

	List<StackLocal> stacks = new ArrayList<StackLocal>();

	public int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	void push(int v) {
		StackLocal last = getLastStack();
		if (last != null && !last.isFull()) {// add to last stack
			last.push(v);
		} else {// must create new stack
			StackLocal stack = new StackLocal(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	int pop() throws EmptyStackException {
		StackLocal last = getLastStack();
		if (last == null)
			throw new EmptyStackException();

		int v = (int) last.pop();
		if (last.size == 0)
			stacks.remove(stacks.size() - 1);
		return v;
	}

	public StackLocal getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {
		StackLocal stack = stacks.get(index);
		int removed_item;
		if (removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();
		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}

}

class StackLocal<T> {

	private static class Node<T> {
		private T value;
		private Node<T> below;
		private Node<T> above;

		public Node(T data) {
			this.value = data;
		}
	}

	public Node<T> top;
	public Node<T> bottom;

	private int capacity;

	public int size = 0;

	public StackLocal(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public void join(Node<T> above, Node<T> below) {
		if (below != null)
			below.above = above;
		if (above != null)
			above.below = below;
	}

	public boolean push(int v) {
		if (size >= capacity)
			return false;
		size++;
		Node<T> n = new Node(v);
		if (size == 1)
			bottom = n;
		join(n, top);
		top = n;
		return true;
	}

	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return (Integer) t.value;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null)
			bottom.below = null;
		size--;
		return (Integer) b.value;
	}
}
