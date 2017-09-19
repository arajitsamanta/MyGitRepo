/**
 * 
 */
package com.arajit.crack.code.ch01.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author as47775
 * 
 * Problem:
 * =======
 * Given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x. 
 * 
 * e.g. 
 * Input:
 * arr[]={3,2,1,4,5}
 * sum=6
 * 
 * Output:
 * Pairs are 2,4 and 1,5
 * 
 * Solution:
 * 1) Initialize Binary Hash Map M[] = {0, 0, ...}
 * 2) Do following for each element A[i] in A[]
 *  	(a)	If M[x - A[i]] is set then print the pair (A[i], x - A[i])
 *      (b)	Set M[A[i]]
 *
 */
public class FindPairSumInArray {

	// Solution using Java hash map
	public boolean findSum(int[] arr,int sum){
		Map<Integer,Boolean> numMap=new HashMap<Integer,Boolean>();
		for(int i=0;i<arr.length;i++){
			int target=sum-arr[i];
			if(target>=0 && null!=numMap.get(target) && numMap.get(target)){
				System.out.println("Pair with given sum " +
                        sum + " is (" + arr[i] +
                        ", "+target+")");
			}
			numMap.put(arr[i],true);			
		}
				
		return true;
	}
	
	//Solution using plain boolean array
	void printpairs(int arr[],int sum)
    {
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[200];
 
        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];
 
            // checking for condition
            if (temp>=0 && binmap[temp])
            {
                System.out.println("Pair with given sum " +
                                    sum + " is (" + arr[i] +
                                    ", "+temp+")");
            }
            binmap[arr[i]] = true;
        }
    }
	@Test
	public void findSumTest(){
		
		int arr[]={3,2,1,4,5};
		findSum(arr,6);
		
		printpairs(arr,6);
	}

}
