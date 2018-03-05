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
package com.arajit.code.practise.gfg.google;

import java.util.Scanner;

/**
 * 
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a
 * given number.
 *
 * Input: 
 * ===== 
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consists of two lines. The first line of each test case
 * is N and S, where N is the size of array and S is the sum. The second line of each test case
 * contains N space separated integers denoting the array elements.
 *
 * Output: 
 * ====== 
 * Corresponding to each test case, in a new line, print the starting and ending
 * positions of first such occurring subarray if sum equals to subarray, else print -1.
 *
 * Note: Position of 1st element of the array should be considered as 1.
 *
 * Expected Time Complexity: O(n)
 * 
 * Constraints: 
 * =========== 
 * 1 ≤ T ≤ 100 
 * 1 ≤ N ≤ 100 
 * 1 ≤ an array element ≤ 200
 *
 * Example: 
 * #######
 * Input: 
 * ===== 
 * 2 
 * 5 12 
 * 1 2 3 7 5 
 * 10 15 
 * 1 2 3 4 5 6 7 8 9 10
 * Output: 
 * ====== 
 * 2 4 
 * 1 5
 * 
 * Explanation: 
 * =========== 
 * In first test case, sum of elements from 2nd position to 4th position is
 * 12 In second test case, sum of elements from 1st position to 5th position is 15
 */
public class FindContiguousSumArray {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int testCases = input.nextInt();
    while (testCases > 0) {
      int arrSize = input.nextInt();
      int targetSum = input.nextInt();
      int[] arr = new int[arrSize];
      for (int idx = 0; idx < arrSize; idx++) {
        arr[idx] = input.nextInt();
      }
      subArraySumBruteForce(arr, arrSize, targetSum);
      testCases--;
    }
    
    input.close();
  }

  /**
   * Returns true if the there is a subarray of arr[] with sum equal to 'sum' otherwise returns
   * false. Also, prints the result.
   * 
   * Time complexity O(n*2)
   * 
   * @param arr
   * @param n
   * @param s
   */
  static int subArraySumBruteForce(int arr[], int n, int sum) {
    int curr_sum, i, j;

    // Pick a starting point
    for (i = 0; i < n; i++) {
      curr_sum = arr[i];

      // try all subarrays starting with 'i'
      for (j = i + 1; j <= n; j++) {
        if (curr_sum == sum) {
          System.out.println("Sum found between indexes " + i + " and " + (j - 1));
          return 1;
        }
        if (curr_sum > sum || j == n)
          break;
        curr_sum += arr[j];
      }
    }

    System.out.println("No subarray found");
    return 0;
  }

}
