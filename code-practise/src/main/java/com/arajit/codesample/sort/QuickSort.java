package com.arajit.codesample.sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,5,7,1,6,78,8};
		quickSort(arr,0,6);
		//print(arr);
	}
	
	static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	      while (i <= j) {
	    	  while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	      System.out.println(i+" "+j);
	      print(arr);
	      return i;
	}

	 

	static void  quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);	    
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	      
	      
	}
	
	public static void print(int[] arr){
		for(int idx=0;idx<arr.length;idx++){
			System.out.println(" "+arr[idx]);
		}
		
	}
}
