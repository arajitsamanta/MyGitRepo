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

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {

  // Function to check if sub-array with 0 sum is present
  // in the given array or not
  public static Boolean zeroSumSubarray(int[] A) {
    // create an empty set to store sum of elements of each
    // sub-array A[0..i] where 0 <= i < arr.length
    Set<Integer> set = new HashSet<>();

    // insert 0 into set to handle the case when sub-array with
    // 0 sum starts from index 0
    set.add(0);

    int sum = 0;

    // traverse the given array
    for (int i = 0; i < A.length; i++) {
      // sum of elements so far
      sum += A[i];

      // if sum is seen before, we have found a sub-array with 0 sum
      if (set.contains(sum)) {
        return true;
      }

      // insert sum so far into set
      set.add(sum);
    }

    // we reach here when no sub-array with 0 sum exists
    return false;
  }

  // main function
  public static void main(String[] args) {
    int[] A = {4, -5, 3, -1, 4, 2, 7};

    if (zeroSumSubarray(A)) {
      System.out.println("Subarray exists");
    } else {
      System.out.println("Subarray do not exist");
    }
  }
}
