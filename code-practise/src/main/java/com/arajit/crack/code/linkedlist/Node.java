package com.arajit.crack.code.linkedlist;

import java.util.HashSet;
import java.util.Stack;


/**
 * @author as47775
 * 
 * A simple class to represent a linked list using an integer data element and a pointer/instance of this class represent connection to the next linked list node 
 * 
 */
public class Node<T> {
	
	T data;

	Node<T> next=null;	
	
	public Node(T data) {
		this.data=data;
	}
	

	public Node() {
		// TODO Auto-generated constructor stub
	}

	/*public Node(int data2) {
		// TODO Auto-generated constructor stub
	}*/


	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @param sum
	 * 
	 * Append a node at the end of a linked list
	 */
	void appendToEnd(T sum){
		Node<T> end=new Node<T>(sum);
		Node<T> n=this;
		while(n.next!=null){
			n=n.next;
		}
		n.next=end;
	}	
	
	
	/**
	 * In order to remove duplicates from a linked list, we need to be able to track duplicates. A simple hash table
     * will work well here.
     * 
     * In the below solution, we simply iterate through the linked list, adding each element to a hash table. When we discover a duplicate element, we remove the element and continue iterating.
     * We can do this all in one pass since we are using a linked list.
     * 
     * The above solution takes O(N) time, where N is the number of elements in the linked list.
	 */
	void removeDuplicates() {
		HashSet<T> set = new HashSet<T>();
		Node<T> previous = null;
		Node<T> head=this;
		while (head != null) {
			if (set.contains(head.data)) {
				previous.next = head.next;
			} else {
				set.add(head.data);
				previous = head;
			}
			head = head.next;
		}
	}
	
	/**
	 * If we don't have a buffer, we can iterate with two pointers: current which iterates through the linked list, and runner which checks all subsequent nodes for duplicates.
	 * 
	 * This code runs in O ( 1) space, but O ( N2) time.
	 */
	void removeDuplicatesNoBuffer() {
		Node<T> runner = null;
		Node<T> head=this;
		while (head != null) {
			runner=head;
			while(runner.next!=null){
				if(runner.next.data==head.data){
					runner.next=runner.next.next;
				}else{
					runner=runner.next;
				}				
			}			
			head = head.next;
		}
	}
	
	/**
	 * @param n
	 * 
	 * This is an iterative approach through which we first find the nth position in linked list, once found print rest of the linked list.
	 */
	void printNthToLast(int n){
		Node<T> nthListhead=find(n);
		System.out.println("\n\n**** print nth to last****");
		display(nthListhead);
	}
	
	/**
	 * @param n
	 * @return nth Node instance
	 */
	Node<T> find(int n){
		if(n==0)
			return null;
		Node<T> head=this;
		int count=0;
		while(head.next!=null){
			count++;
			if(n==count){
				return head;
			}
			head=head.next;
		}
		return null;
	}
	
	
	/**
	 * @param data
	 * @return instance of that particular node
	 */
	Node<T> get(T data){
		Node<T> head=this;
		while(head.next!=null){
			if(data==head.data){
				return head;
			}
			head=head.next;
		}
		return null;
	}
	
	/**
	 * @param head
	 * @param k
	 * 
	 * Remember that recursive solutions are often cleaner but less optimal. For example, in this problem, the recursive implementation is about half the  length of the iterative solution but also takes 0( n) space, 
	 * where n is the number of elements in the linked list.
	 * 
	 * Note that for this solution, we have defined k such that passing ink = 1 would return the last element, k = 2 would return to the second to last element, and so on. It is equally acceptable to define k such that k = 0 would return 
	 * the last element.
	 * @param <T>
	 * 
	 */
	public static <T> int printKthToLastRecursion(Node<T> head, int k) {
		if (head == null) {
			return 0;
		}
		
		int index = printKthToLastRecursion(head.next, k) + 1;
		if (index == k) {
			System.out.println("\n"+ k + "th to last node is " + head.data);
		}
		return index;
	}
	
	
	/**
	 * @param toBeDeleted
	 * @return true if found and deleted, else false
	 * 
	 * Implement an algorithm to delete a node in the middle (i.e., any node but
	 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node. Access to head element is not given.
	 * e.g. 
	 * lnput:the node c from the linked list a->b->c->d->e->f
	 * Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f
	 * 
	 * In this problem, you are not given access to the head of the linked list. You only have access to that node. The solution is simply to copy the data from the next node over to the current node, and then to delete the
	 * next node.
	 */
	boolean deleteNode(Node<T> toBeDeleted, boolean isHeadAccessible){
		if(isHeadAccessible){
			Node<T> head=this;
			if(null==head || null==head.next)
				return false;
			Node<T> previous=null;
			while(head!=null){			
				if(head.data==toBeDeleted.data){
					previous.next=head.next;
					return true;
				}
				previous=head;
				head=head.next;
			}
		}else{
			// with this approach it is not possible to delete the last node.
			if(null==toBeDeleted || toBeDeleted.next==null)
				return false;
			Node<T> next = toBeDeleted.next;
			toBeDeleted.data = next.data;
			toBeDeleted.next = next.next;
			return true;
		}
		
		return false;
	}
	
		
	/**
	 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list the values 
	 * of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the  "right partition"; it does not need to appear between the left 
	 * and right partitions.
	 * 
	 * e.g
	 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
	 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
	 * 
	 * Pass in the head of the linked list and the value to partition around
	 * @return 
	 *  
	 */
	Node<T> partition(Node<T> node, int x) {
		Node<T> beforeStart = null;
		Node<T> beforeEnd = null;
		Node<T> afterStart = null;
		Node<T> afterEnd = null;

		/* Partition list */
		while (node != null) {
			Node<T> next = node.next;
			node.next = null;

			if (Integer.valueOf((Integer) node.data).intValue() < x) {
				/* Insert node into end of before list */
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				/* Insert node into end of after list */
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}			
			node=next;
		}

		if (beforeStart == null) {
			return afterStart;
		}
		
		/* Merge before list and after list */
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	/**
	 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
	 * function that adds the two numbers and returns the sum as a linked list.
	 * 
	 * e.g
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
     * Output: 2 -> 1 -> 9. That is, 912.
	 * @param l1
	 * @param l2
	 * @param carry
	 * @return Node<T>
	 */
	Node<T> addLists(Node<T> l1, Node<T> l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		Node<T> result = new Node<T>();

		int value = carry;

		if (l1 != null) {
			value += Integer.valueOf((Integer) l1.data);
		}
		if (l2 != null) {
			value += Integer.valueOf((Integer) l2.data);
		}

		
		result.data = (T)(Object)(value % 10); /* Second digit of number */

		/* Recurse */
		if (l1 != null || l2 != null) {
			Node<T> more = addLists(l1 == null ? null : l1.next,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}
	
	/**
	 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
	 * function that adds the two numbers and returns the sum as a linked list.
	 * 
	 * e.g
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
     * Output: 2 -> 1 -> 9. That is, 912.
	 * @param l1
	 * @param l2
	 * @param carry
	 * @return Node<T>
	 */
	Node<T> addListsMyImplementation(Node<T> l1, Node<T> l2) {
		int len1=length(l1);
		int len2=length(l2);
		
		if(len1<len2){
			l1=padList(l1,len2-len1);
		}else{
			l2=padList(l2,len1-len2);
		}
		
		int sum=0;
		int carry=0;
		Node<Integer> finalList=null;
		while(l1!=null && l2!=null){
			sum=carry+Integer.valueOf((Integer)l1.data).intValue()+Integer.valueOf((Integer)l2.data).intValue();
			carry=0;
			if(sum >=10){
				carry = sum /10;
				sum =sum % 10;				
			}
			if(null==finalList){
				Node<Integer> node=new Node<Integer>(sum);
				finalList=node;
			}else{
				finalList.appendToEnd(sum);
			}		
			l1=l1.next;
			l2=l2.next;
		}
		
		if(carry>0)
			finalList.appendToEnd(carry);
	
		return (Node<T>) finalList;
	}
	
	/* Pad the list with zeros */
	Node<T> padList(Node<T> list, int padCount) {
		Node<T> head = list;
		T toBePadded=(T)(Object)0;
		for (int i = 0; i < padCount; i++) {
			head = appendBefore(head, toBePadded);
		}
		return head;
	}

	
	
	/**
	 * Reverse a linked list
	 * @param head
	 * @return
	 */
	public Node<T> reverse(Node<T> head){
		if(head==null)
				return null;
		Node<T> newHead=null;
		while(head!=null){
			Node<T> node=new Node<T>(head.data);
			node.next=newHead;
			newHead=node;
			head=head.next;
		}
		return newHead;
	}
	
	public boolean isEqual(Node<T> one, Node<T> two){
		
		while(one!=null && two!=null){
			if(one.data!=two.data)
				return false;
			one=one.next;
			two=two.next;
		}
		
		return one==null & two==null;
	}
	
	/**
	 * Push elements from first half of linked list onto stack. When fast runner (which is moving at 2x speed) reaches the end of the linked list, then we 
	 * know we're at the middle
	 *
	 */
	public boolean isPalindrome(Node<T> head){
		Node<T> slow=head;
		Node<T> fast=head;
		
		Stack<Integer> stack=new Stack<Integer>();
		
		while(fast!=null && fast.next!=null){
			stack.push((Integer)slow.data);
			slow=slow.next;
			fast=fast.next.next;
		}
		
		/* Has odd number of elements, so skip the middle element */
		if(fast!=null)
			slow=slow.next;
		
		while(slow!=null){
			int top=stack.pop().intValue();
			if(top!=(int)(Object)slow.data){
				return false;
			}
			slow=slow.next;
		}
		
		return true;
	}
	
	private class Result {
		
		public Node<T> node;
		public boolean result;
		 
		public Result(Node<T> head, boolean b) {
			this.node=head;
			this.result=b;
		}
		
	}
	/**
	 * @param head
	 * @return boolean
	 */
	boolean isPalindromeRecursion(Node<T> head) {
		 int length= length(head);
		 Result p = isPalindromeRecurse(head, length);
		 return p.result;
	 }
	
	/**
	 * Now, like many linked list problems, you can approach this problem recursively. We may have some intuitive
	 * idea that we want to compare element 0 and element n - 1, element 1 and element n - 2, element 2
	 * and element n-3, and so on, until the middle element(s). For example:
	 *  0 ( 1 ( 2 ( 3 ) 2 ) 1 ) 0
	 * In order to apply this approach, we first need to know when we've reached the middle element, as this will
	 * form our base case. We can do this by passing in length - 2 for the length each time. When the length
	 * equals 0 or 1, we're at the center of the linked list. This is because the length is reduced by 2 each time. Once
	 * we've recursed Yi times, length will be down to 0.
	 *
	 * @param head
	 * @param len
	 * @return
	 */
	Result isPalindromeRecurse(Node<T> head, int len) {
		if (head == null || len <= 0) { // Even number of nodes
			return new Result(head, true);
		} else if (len == 1) { // Odd number of nodes
			return new Result(head.next, true);
		}

		/* Recurse on sublist. */
		Result res = isPalindromeRecurse(head.next, len - 2);

		/* If child calls are not a palindrome, pass back up a failure. */

		if (!res.result || res.node == null) {
			return res;
		}

		/* Check if matches corresponding node on other side. */
		res.result = (head.data == res.node.data);

		/* Return corresponding node. */
		res.node = res.node.next;

		return res;
	}
	
	
	
	/**
	 * Given two (singly) linked lists, determine if the two lists intersect. Return the
	 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
	 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
	 * linked list, then they are intersecting.
	 *
	 * We have a multi-step process to find out 
	 * 1. Run through each linked list to get the lengths and the tails.
	 * 2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
	 * 3. Set two pointers to the start of each linked list.
	 * 4. On the longer linked list, advance its pointer by the difference in lengths.
	 * 5. Now, traverse on each linked list until the pointers are the same.
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public Node<T> findIntersection(Node<T> list1,Node<T> list2){
		if(list1==null || list2==null)
			return null;
		
		/* Get tail and size */
		ResultIntersecion result1=getTailAndSize(list1);
		ResultIntersecion result2=getTailAndSize(list2);
		
		System.out.println(result1.tail+ " " + result1.size);
		System.out.println(result2.tail+ " " + result2.size);
		/* If different tail, return null as there is no intersection */
		if(result1.tail!=null && result2.tail!=null)
			return null;
		
		Node<T> shorter = result1.size < result2.size ? list1 : list2;
		Node<T> longer = result1.size < result2.size ? list2 : list1;
		
		/* Advance the pointer for the longer linked list by difference in lengths. */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		
		/* Return either one. */
		return longer;
	}
	

	private class ResultIntersecion {
		
		public Node<T> tail;
		public int size;
		 
		public ResultIntersecion(Node<T> head, int size) {
			this.tail=head;
			this.size=size;
		}
		
	}
	
	ResultIntersecion getTailAndSize(Node<T> node){
		if(node==null)
				return null;
		int len=1;
		while(node.next!=null){
			len++;
			node=node.next;
		}
		
		return new ResultIntersecion(node,len);
	}
	
	Node<T> getKthNode(Node<T> head, int k) {
		Node<T> current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	
	
	/* return length of linked list*/
	int length(Node<T> head){
		if(null==head)
			return 0;
		int length=0;
		while(head!=null){
			length++;
			head=head.next;
		}
		return length;
	}
	
	public void createCircularList(Node<T> head, int position){
		Node<T> circularPoint=getKthNode(head,position);
		System.out.println(circularPoint.data);
		Node<T> last=getLast(head);
		System.out.println(last.data);
		last.next=circularPoint;		
	}
	
	public Node<T> findCircularPoint(Node<T> head){
		
		return null;
	}
	
	public Node<T> getLast(Node<T> head){
		if(head==null)
			return null;
		while(head.next!=null)
			head=head.next;
		return head;
	}
	
	/**
	 * @param head
	 * 
	 * Simple print method to display linked list from start to end.
	 */
	public void display(Node<T> head){
		while(head!=null){
			if(head.next!=null)
				System.out.print(head.data+"->");
			else
				System.out.print(head.data);
			head = head.next;
		}
	}
	
	/* Helper function to insert node in the front of a linked list */
	Node<T> appendBefore(Node<T> list, T data) {		
		Node<T> node = new Node<T>(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}
	
}
