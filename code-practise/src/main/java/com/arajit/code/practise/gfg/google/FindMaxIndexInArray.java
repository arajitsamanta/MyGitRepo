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
import java.util.Stack;

public class FindMaxIndexInArray {

  public static int maxIndexDiff(int arr[], int n) {
    Stack<Integer> stk = new Stack<Integer>();
    for (int i = 0; i < n; ++i) {
      if (stk.isEmpty() || arr[i] < arr[stk.peek()])
        stk.push(i);
    }
    int res = -1;
    for (int i = n - 1; i >= 0; --i) {
      while (!stk.isEmpty() && arr[i] >= arr[stk.peek()])
        res = Math.max(res, i - stk.pop());
      // remove all values which have processed i.e. index that has been used
      while (!stk.isEmpty() && i < stk.peek())
        stk.pop();
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner ab = new Scanner(System.in);
    int t = ab.nextInt();
    while (t-- > 0) {
      int n = ab.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; ++i)
        arr[i] = ab.nextInt();
      System.out.println(maxIndexDiff(arr, n));
    }
    ab.close();
  }
}  
  
