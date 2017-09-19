/**
 * 
 */
package com.arajit.crack.code.ch01.arraysandstrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author as47775
 * 
 * Problem:
 * ========
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * Two strings said to be permutation of one another if no-of  chars in each string is identical.
 * 
 * e.g. 
 * original string -> aabcb
 * permutation string -> abcba, bacab
 * 
 * Solution 1:
 * ==========
 * If two strings are permutations, then we know they have the same characters, but in different orders. Therefore,
 * sorting the strings will put the characters from two permutations in the same order. We just need to
 * compare the sorted versions of the strings.
 * 
 * Solution 2:
 * ==========
 * Two string can be called permutation of one another if no-of  chars in each string is identical.
 */
public class StringPermutations {

	String sort(String str){
		char[] content=str.toCharArray();
		Arrays.sort(content);		
		return new String(content);
	}
	
	//Solution 1
	boolean isPermutation(String str1,String str2){
		if(str1.length()!=str2.length())
			return false;
		
		return sort(str1).equals(sort(str2)); 
	}
	
	//Solution 2: Two string can be called permutation of one another if no-of  chars in each string is identical.
	boolean isPermutationEfficinet(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[128]; // Assumption
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			//System.out.println(letters[c]);
			if (letters[c] < 0) {
				System.out.println(c+"   "+letters[c]);
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void isPermutationTest(){
		String str1="god";
		String str2="dog";		
		assertTrue(isPermutationEfficinet(str1, str2));	
		
		str1="god    is great";
		str2="dog    is argte";
		
		assertTrue(isPermutationEfficinet(str1, str2));
		
		str1="god    is great";
		str2="dod    is argte";
		
		assertFalse(isPermutationEfficinet(str1, str2));
	}
	

}
