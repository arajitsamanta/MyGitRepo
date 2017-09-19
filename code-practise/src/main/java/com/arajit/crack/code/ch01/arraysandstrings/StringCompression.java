/**
 * 
 */
package com.arajit.crack.code.ch01.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author as47775
 *
 * Problem:
 * ========  
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string 
 * would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * 
 * Solution:
 * ========
 * At first glance, implementing this method seems fairly straightforward, but perhaps a bit tedious. We iterate through the string, copying characters to a new string and counting 
 * the repeats. At each iteration, check if the current character is the same as the next character. If not, add its compressed version to the result.
 * 
 */
public class StringCompression {
	
	// Solution using String
	String compressBad(String str) {
		String compressedString = "";
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			/*
			 * If next character is different than current, append this char to
			 * result.
			 */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString : str;
	}
	
	
	//Solution using StringBuilder
	String compresssString(String str){
		int count=0;
		StringBuilder compressedStr=new StringBuilder();
		for(int i=0;i<str.length();i++){
			count++;
			if(i+1>=str.length() || str.charAt(i)!=str.charAt(i+1)){				
				compressedStr.append(str.charAt(i));
				compressedStr.append(count);	
				count=0;
			}
		}
		return compressedStr.length() < str.length() ? compressedStr.toString() : str;
	}
	
	@Test
	public void compresssStringTest(){
		String str="aabc";
		String str1="aabcccccaaa";
		assertEquals("aabc", compresssString(str));
		assertEquals("a2b1c5a3", compresssString(str1));
	}
}
