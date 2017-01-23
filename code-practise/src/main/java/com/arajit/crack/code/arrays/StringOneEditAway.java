package com.arajit.crack.code.arrays;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author as47775
 *
 * Problem:
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 * 
 * Solution 1:
 * ==========
 * This is one of those problems where it's helpful to think about the "meaning" of each of these operations.
 * What does it mean for two strings to be one insertion, replacement, or removal away from each other?
 * 
 * Replacement
 * =========== 
 * Consider two strings, such as bale and pale, that are one replacement away. Yes, that  does mean that you could replace a character in bale to make pale. 
 * But more precisely, it means that  they are different only in one place.
 * 
 * Insertion
 * ==========
 * The strings apple and aple are one insertion away. This means that if you compared the strings, they would be identical-except for a shift at some point in the strings.
 * 
 * Removal
 * ======= 
 * The strings apple and aple are also one removal away, since removal is just the inverse of  insertion.
 * 
 */
public class StringOneEditAway {

	boolean isOneEditAway(String str1, String str2){
		if(str1.length()==str2.length())
			return oneEditReplace(str1,str2);
		else if(str1.length()+1==str2.length())
			return oneEditInsert(str1,str2);
		else if(str1.length()-1==str2.length())
			return oneEditInsert(str2,str1);
		return false;
	}
	
	boolean oneEditReplace(String s1,String s2){
		boolean found=false;;
		for(int idx=0;idx<s1.length();idx++){
			if(s1.charAt(idx)!=s2.charAt(idx)){
				if(found) return false;
				found=true;
			}
		}
		return true;
	}
	
	boolean oneEditInsert(String s1,String s2){
		int idx1=0,idx2=0;
		while(idx2<s2.length() && idx1<s1.length()){
			if(s2.charAt(idx2)!=s1.charAt(idx1)){
				if(idx2!=idx1) {
					return false;
				}
				idx2++;
			}else{
				idx1++;
				idx2++;
			}
		}
		return true;
	}
	
	boolean oneEditAway(String first, String second) {
		/* Length checks. */
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}

		/* Get shorter and longer string. */
		String sl = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;

		int indexl = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && indexl < sl.length()) {
			if (sl.charAt(indexl) != s2.charAt(index2)) {

				/* Ensure that this is the first difference found. */
				if (foundDifference)
					return false;
				foundDifference = true;

				if (sl.length() == s2.length()) {// On replace, move shorter pointer
					indexl++;
				}
			} else {
				indexl++; // If matching, move shorter pointer
				index2++; // Always move pointer for longer string
			}
		}
		return true;
	}

	@Test
	public void isOneEditAwayTest(){
		String s1="palebbb"; String s2="palebbbb";
		assertTrue(isOneEditAway(s1,s2));
		
		s1="palebbab";  s2="palebbbb";
		assertTrue(oneEditAway(s1,s2));
	}
	
}
