/**
 * 
 */
package com.arajit.crack.code.recursion;

/**
 * @author as47775
 * 
 * Problem
 * =======
 * magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]=i. 
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicNumber {
	
	int magicSlow(int[] arr){
		for(int idx=0;idx<arr.length;idx++){
			if(arr[idx]==idx)
				return idx;
		}
		return -1;
	}
	
	int magicFast(int[] arr){
		return magicFast(arr,0,arr.length-1);
	}
	
	int magicFast(int[] arr, int start, int end){
		
		if(end < start)
			return -1;
		
		int mid=(start+end)/2;
		
		if(arr[mid]==mid)
			return mid;
		else if(arr[mid] > mid)
			return magicFast(arr,start,mid-1);
		else 
			return magicFast(arr,mid+1,end);
	}
	
	int magicFastDuplicates(int[] arr){
		return magicFastDuplicates(arr,0,arr.length-1);
	}
	
	/**
	 * 
	 * If the elements are not distinct, then this algorithm fails. Consider the following array:
	 * 
	 * [-10,-5,2,2,2,3,4,7,9,12,13]
	 * 
	 * When we see that A [mid] < mid, we cannot conclude which side the magic index is on. It could be on the right side, as before. Or, it could be on the left side (as it, in fact, is).
	 * Could it be anywhere on the left side? Not exactly. Since A[ 5] = 3, we know that A[ 4] couldn't be a magic	index.
	 *  
	 * A[ 4] would need to be 4 to be the magic index, but A[ 4] must be less than or equal to A[ 5].
	 * In fact, when we see that A[ 5] = 3, we'll need to recursively search the right side as before. But, to search the left side, we can skip a bunch of elements and only recursively search elements A [ 0] through A [ 3].
	 * A [ 3] is the first element that could be a magic index.
	 * The general pattern is that we compare mid Index and midValue for equality first. Then, if they are not equal, we recursively search the left and right sides as follows:
	 *		 Left side: search indices start through Math. min (midlndex - 1, midValue ).
	 *		 Right side: search indices Math. max(midlndex + 1, midValue) through end.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	int magicFastDuplicates(int[] arr, int start, int end) {

		if (end < start)
			return -1;
		//Find the middle index
		int midIndex = (start + end) / 2;

		int midValue = arr[midIndex];

		if (midIndex == midValue)
			return midIndex;

		/* Search left */
		int leftindex = Math.min(midIndex - 1, midValue);
		int left = magicFastDuplicates(arr, start, leftindex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastDuplicates(arr, rightIndex, end);

		return right;

	}
	
	public static void main(String[] args){
		
		MagicNumber finder=new MagicNumber();
		
		int[] magicArr={-10,-5,2,2,2,3,4,7,9,12,13};
		
		System.out.println("magic index(Slow) is -> "+finder.magicSlow(magicArr));
		
		System.out.println("magic index(fast) is -> "+finder.magicFast(magicArr));
		
		System.out.println("magic index(fast) is -> "+finder.magicFastDuplicates(magicArr));
	}
}
