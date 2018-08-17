package com.arajit.code.google.devguide;


/**
 * http://codingbat.com/prob/p189576
 *
 */
public class MaximumSpanInArray {

  public static void main(String[] args) {
    int[] input= {1,4,2,1,4,1,4};
    maxSpan(input);
  }
  
  public static int maxSpan(int[] nums) {
    int max=0;
    int len=nums.length;
    int span=0;
    for(int i=0;i<len;i++) {
      for(int j=len-1;j>=i;j--) {
        if(nums[i]==nums[j]) {
          span=j-i+1;
          if(span>max) {
            max=span;
          }
          break;
        }
      }
    }
    return max;
  }

}
