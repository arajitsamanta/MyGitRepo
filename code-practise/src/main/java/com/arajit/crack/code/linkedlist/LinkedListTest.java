/**
 * 
 */
package com.arajit.crack.code.linkedlist;

import org.junit.Test;

/**
 * @author as47775
 *
 */
public class LinkedListTest {
	
	Node<Integer> linkedList;
	
	@Test
	public void removeDuplicateTest(){
		/*int[] linkedListElements={7,1,6,5,10,2,1,7};
		Node<Integer> linkedList=createLinkedlist(linkedListElements);
		System.out.println("****Original List****");
		linkedList.display(linkedList);
		
		linkedList.appendToEnd(9);
		System.out.println("\n\n****After appending a node at the end of List****");
		linkedList.display(linkedList);
		
		linkedList.removeDuplicates();
		//linkedList.removeDuplicatesNoBuffer();
		System.out.println("\n\n****After removing duplicates****");
		linkedList.display(linkedList);
		
		linkedList.printNthToLast(4);
		Node.printKthToLastRecursion(linkedList, 4);
		
		//First get the instance of nth node and the call deleteNode() with isHeadAccessible=false				
		linkedList.deleteNode(linkedList.get(3),false);
		System.out.println("\n\n****After deleting a node List(isHeadAccessible=false)****");
		linkedList.display(linkedList);
		
		//if we have access to head just create a Node instance for that element and call deleteNode() with isHeadAccessible=true				
		linkedList.deleteNode(new Node<Integer>(2),true);		
		System.out.println("\n\n****After deleting a node List(isHeadAccessible=true)****");
		linkedList.display(linkedList);
		
		int partitionElement=5;
		Node<Integer> linkedListAfterPartition=linkedList.partition(linkedList, partitionElement);
		System.out.println("\n\n****After partioning linked list ****" + " around "+partitionElement);
		linkedList.display(linkedListAfterPartition);
		*/
		/*int[] list1={6,1,7};
		Node<Integer> linkedList1=createLinkedlist(list1);
		System.out.println("****Original List****");
		linkedList.display(linkedList1);
		int[] list2={5,9,2};
		Node<Integer> linkedList2=createLinkedlist(list2);
		System.out.println("\n****Original List****");
		linkedList.display(linkedList2);
		//Node<Integer> linkedListAfterAddition=linkedList.addListsMyImplementation(linkedList1, linkedList2);
		Node<Integer> linkedListAfterAddition=linkedList.addLists(linkedList1, linkedList2,0);
		System.out.println("\n****After addition List****");		
		linkedList.display(linkedListAfterAddition);*/
		
	/*	int[] list1={1,2,1};
		Node<Integer> linkedList=createLinkedlist(list1);
		System.out.println("****Original List****");
		linkedList.display(linkedList);
		
		Node<Integer> reverseList=linkedList.reverse(linkedList);
		System.out.println("\n ****Reverse List****");
		linkedList.display(reverseList);
		
		System.out.println("\nLinked list is palindrome -> "+linkedList.isEqual(linkedList, reverseList));*/
		
		int[] list1={1,2,3,4,5};
		Node<Integer> linkedList1=createLinkedlist(list1);
		//System.out.println("\nLinked list is palindrome -> "+linkedList.isPalindromeRecursion(linkedList));
		
		/*int[] list2={3,2,1};
		Node<Integer> linkedList2=createLinkedlist(list2);
		
		Node<Integer> intersectionPoint=linkedList1.findIntersection(linkedList1, linkedList2);
		//System.out.println("\n Intersection is palindrome -> " );
		//intersectionPoint.display(intersectionPoint);*/
		linkedList1.createCircularList(linkedList1, 2);
		//linkedList1.display(linkedList1);
		linkedList1.findCircularPoint(linkedList1);
	
	}
	
	
	public Node<Integer> createLinkedlist(int[] arr){
		//linkedList=new Node<Integer>(3);
		linkedList=new Node<Integer>(arr[0]);
		for(int idx=1;idx<arr.length;idx++)
			 linkedList.appendToEnd(arr[idx]);
		return linkedList;
	}
	
	
	
	
}
