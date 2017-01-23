/**
 * 
 */
package com.arajit.crack.code.arrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author as47775
 * 
 * Problem:
 * ========
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 *	
 * Solution: 
 * =========
 * 1. Create an array of boolean values of size 128(Assumption is that string will contain  only ASCII chars)
 * 2. Iterate over the string and set the corresponding index in boolean array as true. return false if the arr[index] is already true.
 */
public class IsUniqueCharacter {
	
	// Time complexity is O(n)
	public boolean isUniqueChar(String str) {
		if (str.length() > 128)
			return false;

		boolean[] char_set = new boolean[128];

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) { // Already found this char in string
				return false;
			}
			char_set[val] = true;
		}

		return true;
	}
	
	// Time complexity is O(n)
	public boolean isUniqueCharBitVector(String str) {
		int checker=0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1<<val))>0) { 
				return false;
			}
			checker|=(1<<val);
		}
		return true;
	}
	
	// Time complexity is O(n)
	public boolean isUniqueCharUsingSorting(String str) {
		char[] arr=str.toCharArray();
		Arrays.sort(arr); // this has a time complexity of O(n log n)
		System.out.println(arr);
		for (int i = 0; i < arr.length; i++) { // This has a complexity of O(n) 
			if((i+1)<arr.length && arr[i]==arr[i+1]){
				return false;
			}			
		}
		return true;
	}
	
	
	@Test
	public void isUniqueCharTest(){
		
		String str="abcddefgggƒƒƒƒƒƒ";
		assertFalse(isUniqueChar(str));
		
		str="abcdefg";
		assertTrue(isUniqueChar(str));
		
		str="abcadefg";
		assertFalse(isUniqueCharBitVector(str));
		
		str="iasckgack";
		assertFalse(isUniqueCharUsingSorting(str));
		
		str="jhiytebplu";
		assertTrue(isUniqueCharUsingSorting(str));
	}
	

}
