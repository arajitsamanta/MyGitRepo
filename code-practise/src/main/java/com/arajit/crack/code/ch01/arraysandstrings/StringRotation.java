package com.arajit.crack.code.ch01.arraysandstrings;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author as47775
 *
 * Problem:
 * ========  
 * Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to i5Sub5tring 
 * 
 * e.g., "waterbottle" is a rotation of" erbottlewat"
 * 
 * Solution:
 * ========
 * If we imagine that 52 is a rotation of 51, then we can ask what the rotation point is. For example, if you rotate waterbottle after wat. you get erbottlewat. In a rotation, 
 * we cut 51 into two parts, x and y, and rearrange them to get 52.
 * S1 = xy = waterbottle
 * x = wat  
 * y = erbottle
 * s2 = yx = erbottlewat
 * 
 * So, we need to check if there's a way to split s1 into x and y such that xy = s1 and yx = s2. Regardless of where the division between x and y is, we can see that yx will always be a 
 * substring of xyxy.That is, s2 will always be a substring of s1s1.
 */
public class StringRotation {

	boolean isSubstring(String s1, String s2) {
		System.out.println("index::"+s1.indexOf(s2));
		if (s1.indexOf(s2) < 0){
			System.out.println("index::"+s1.indexOf(s2));
			return false;
		}
		return true;
	}

	boolean isRotation(String sl, String s2) {
		int len = sl.length();
		/* Check that sl and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* Concatenate sl and sl within new buffer */
			String slsl = sl + sl;
			return isSubstring(slsl, s2);
		}
		return false;
	}
	
	@Test
	public void isRotationTest(){
		String s1="waterbottle", s2="erbottlewat";
		assertTrue(isRotation(s1,s2));
	}

}
