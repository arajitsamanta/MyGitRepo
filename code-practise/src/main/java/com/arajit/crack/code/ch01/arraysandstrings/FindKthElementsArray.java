/**
 * 
 */
package com.arajit.crack.code.ch01.arraysandstrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author as47775
 * 
 * Problem
 * ======= 
 * Design an algorithm to find the smallest K numbers in an array.
 * 
 * Solution
 * ========
 * There are a number of ways to approach this problem. We will go through three of them: sorting, max heap,
 * and selection rank.
 * 
 * Sol 1. Brute Force --> 
 * Some of these algorithms require modifying the array. This is something you should discuss with your interviewer.
 * Note, though, that even if modifying the original array is not acceptable, you can always clone the array and modify the clone instead. This will not impact the overall big O time of any algorithm.
 * 
 * Sol 2: Max Heap --> 
 * We can use a max heap to solve this problem. We first create a max heap (largest element at the top) for the first million numbers.
 * Then, we traverse through the list. On each element, if it's smaller than the root, we insert it into the heap and delete the largest element (which will be the root).
 * 
 * At the end of the traversal, we will have a heap containing the smallest one million numbers. This algorithm is O(n log(m) ), where mis the number of values we are looking for.
 */
public class FindKthElementsArray {
	
	/**
	 * @param arr
	 * @param k
	 * @return an array of small elements. 
	 */
	int[] findKthSmallestElements(int[] arr, int k){
		 if (k <= 0 || k > arr.length) 
			 throw new IllegalArgumentException();
		 		
		
		//Pivot based quick sort, complexity  O(n log(n))
		Arrays.sort(arr);
		
		//create an array of size k
		int[] smallest=new int[k];
		
		//Fill array with k small objects
		for(int i=0;i<k;i++)
			smallest[i]=arr[i];
		
		return smallest;
	}
	

	/**
	 * @param arr
	 * @param k
	 * @return an array of large elements. 
	 */
	int[] findKthLargestElements(int[] arr, int k){
		 if (k <= 0 || k > arr.length) 
			 throw new IllegalArgumentException();
		
		//Pivot based quick sort, complexity  O(n log(n))
		Arrays.sort(arr);
		
		//create an array of size k
		int[] largest=new int[k];
		
		//Fill array with k large objects from last
		int reverseIndex=arr.length-1;
		for(int i=0;i<k;i++){
			largest[i]=arr[reverseIndex];
			reverseIndex--;
		}
		
		return largest;
	}
	
	/**
	 * Find k'th smallest element in an array using max heap approach 
	 * @param array
	 * @param k
	 * @return  an array of small elements. 
	 */
	int[] smallestKUsingHeap(int[] array, int k) {
		 if (k <= 0 || k > array.length) {
			 throw new IllegalArgumentException();
		 }
		
		 PriorityQueue<Integer> heap= getKMaxHeap(array, k);
		 return heapTointArray(heap);
	}
	
	/**
	 * Find k'th largest element in an array using min heap approach 
	 * @param array
	 * @param k
	 * @return  an array of small elements. 
	 */
	int[] largestKUsingHeap(int[] array, int k) {
		 if (k <= 0 || k > array.length) {
			 throw new IllegalArgumentException();
		 }
		
		 PriorityQueue<Integer> heap= getKMinHeap(array, k);
		 return heapTointArray(heap);
	}

	/* Create max heap of smallest k elements. */
	PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
		
		// Initialize a comparator  to create a max heap as by default PriorityQueue use natural ordering user creates a mean heap
		Comparator<Integer> intComparator=(Integer x1,Integer x2) -> x2.compareTo(x1);
		
		//create priority queue with size k and max heap comparator
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, intComparator);
		
		for (int a : array) {
			if (heap.size() < k) {// If space remaining
				heap.add(a);
			} else if (a < heap.peek()) {// If full and top is small
				heap.poll();// remove highest
				heap.add(a); // insert new element
			}
			
		}
		return heap;
	}
	
	PriorityQueue<Integer> getKMinHeap(int[] array, int k) {
		
		//create priority queue with size k and max heap comparator
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
		
		for (int a : array) {
			if (heap.size() < k) {// If space remaining
				heap.add(a);
			} else if (a > heap.peek()) {// If full and top is greater
				heap.poll();// remove highest
				heap.add(a); // insert new element
			}
			
		}
		return heap;
	}

	/* Convert heap to int array. */
	int[] heapTointArray(PriorityQueue<Integer> heap) {
		int[] array = new int[heap.size()];
		while (!heap.isEmpty()) {
			array[heap.size() - 1] = heap.poll();
		}
		return array;
	}
	
	public static void main(String[] args){
		int[] arr={1,1,21,8,9,6,858,796,54,-58,85,3};
		FindKthElementsArray finder=new FindKthElementsArray();
		
		
		//Find k smallest elements in an array 
		System.out.println("****Find k smallest elements in an array");
		int[] smallestElems=finder.findKthSmallestElements(arr,2);
		Arrays.stream(smallestElems).forEach(System.out::println);
		
		//Find k smallest elements in an array using max heap approach
		System.out.println("****Find k smallest elements in an array using max heap approach");
		int[] arr2={5,12,1,21,-1};
		int[] smallestElemsUsingHeap=finder.smallestKUsingHeap(arr2,3);
		Arrays.stream(smallestElemsUsingHeap).forEach(System.out::println);
		
		//Find k largest elements in an array 
		System.out.println("**** Find k largest elements in an array ");
		int[] largeElems=finder.findKthLargestElements(arr,6);
		Arrays.stream(largeElems).forEach(System.out::println);
		
		//Find k largest elements in an array 
		System.out.println("Find k smallest elements in an array using min heap approach");
		int[] arr3={5,12,1,21,-1,0,896,18956};
		int[] largeElemsUsingHeap=finder.largestKUsingHeap(arr3,3);
		Arrays.stream(largeElemsUsingHeap).forEach(System.out::println);
		
		
	}

}
