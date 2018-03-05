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
package com.arajit.code.practise.gfg.sorting;

public class HeapSort {
  
  public void sort(int arr[])
  {
      int n = arr.length;

      // Build heap (rearrange array)
      for (int i = n / 2 - 1; i >= 0; i--)
          heapify(arr, n, i);
      
      System.out.println("After Building max heap");
      printArray(arr);
      
      System.out.println("Soritng.....");
      // One by one extract an element from heap
      for (int i=n-1; i>=0; i--)
      {
          // Move current root to end
          int temp = arr[0];
          arr[0] = arr[i];
          arr[i] = temp;

          // call max heapify on the reduced heap
          heapify(arr, i, 0);
      }
  }
  
  /**
   * @param arr The Array 
   * @param size The size of the array
   * @param root The Root index
   */
  void heapify(int arr[],int size,int root) {
    
    int largest = root;  // Initialize largest as root
    int left = 2*root + 1;  // left = 2*root + 1
    int right = 2*root + 2;  // right = 2*root + 2
    
    // If left child is larger than root
    if (left < size && arr[left] > arr[largest])
        largest = left;

    // If right child is larger than largest so far
    if (right < size && arr[right] > arr[largest])
        largest = right;

    // If largest is not root, swap
    if (largest != root)
    {
        int swap = arr[root];
        arr[root] = arr[largest];
        arr[largest] = swap;

        // Recursively heapify the affected sub-tree
        heapify(arr, size, largest);
    }
    System.out.println("Building max heap");
    printArray(arr);
    
  }
  
  /* A utility function to print array of size n */
  static void printArray(int arr[])
  {
      int n = arr.length;
      for (int i=0; i<n; ++i)
          System.out.print(arr[i]+" ");
      System.out.println();
  }
  
  public static void main(String[] args) {
    int[] arr= {12, 11, 13, 5, 6, 7};
    
    int n = arr.length;
    
    HeapSort ob = new HeapSort();
    ob.sort(arr);

    //System.out.println("Sorted array is");
    printArray(arr);
  }

}
