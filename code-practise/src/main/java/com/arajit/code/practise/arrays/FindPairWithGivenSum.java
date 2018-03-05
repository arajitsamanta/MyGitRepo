/*
 * FOR INTERNAL USE ONLY. NOT A CONTRIBUTION.
 *
 * This software source code contains valuable, confidential, trade secret information owned by
 * Enterprise Rent-A-Car Company and is protected by copyright laws and international copyright
 * treaties, as well as other intellectual property laws and treaties.
 *
 * ACCESS TO AND USE OF THIS SOURCE CODE IS RESTRICTED TO AUTHORIZED PERSONS WHO HAVE ENTERED INTO
 * CONFIDENTIALITY AGREEMENTS WITH ENTERPRISE RENT-A-CAR COMPANY.
 *
 * This source code may not be licensed, disclosed or used except as authorized in writing by a duly
 * authorized officer of Enterprise Rent-A-Car Company.
 *
 */
package com.arajit.code.practise.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find a pair with given sum in it.
 * 
 * Input: 
 * arr=[8,7,2,5,3,1] 
 * sum=10
 * 
 * Output: 
 * Pair found at index 0 and 2 (8+2) 
 * or
 * Pair found at index 1 and 4 (7+3)
 * 
 * Time complexity is O(n) and Auxiliary Space used by this program is O(n)
 */
public class FindPairWithGivenSum {

  // Naive method to find a pair in an array with given sum
  public static void findPair(int[] A, int sum) {
    // create an empty Hash Map
    Map<Integer, Integer> map = new HashMap<>();

    // do for each element
    for (int i = 0; i < A.length; i++) {
      // check if pair (arr[i], sum-arr[i]) exists

      // if difference is seen before, print the pair
      if (map.containsKey(sum - A[i])) {
        System.out.println("Pair found at index " + map.get(sum - A[i]) + " and " + i);
        return;
      }

      // store index of current element in the map
      map.put(A[i], i);
    }

    // No pair with given sum exists in the array
    System.out.println("Pair not found");
  }

  // Find pair with given sum in the array
  public static void main(String[] args) {
    int[] A = {8, 7, 2, 5, 3, 1};
    int sum = 10;

    findPair(A, sum);
  }

}
