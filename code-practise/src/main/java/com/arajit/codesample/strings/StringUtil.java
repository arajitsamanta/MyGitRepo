package com.arajit.codesample.strings;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String sourceStr="Battle of the Vowels: Hawaii vs. Grozny";
		//String removeStr="aeiou";
		//System.out.println(removeChars(sourceStr,removeStr));
		
		//String str="teeter";
		/*System.out.println(firstNonRepeatedUnicode(str));
		System.out.println(firstNonRepeatedAscii(str));*/
		
		//System.out.println(reverse(sourceStr));
		//breakIntoSpaces("peanutbutter");
		System.out.println(hasSubstring("looser", "loo"));
		
		
	}
	
	public static String firstNonRepeatedUnicode(String str) {
		HashMap<Integer, Object> charHash = new HashMap<Integer, Object>();
		Object seenOnce = new Object(), seenMultiple = new Object();
		Object seen;
		int i;
		final int length = str.length();
		// Scan str, building hash table
		for (i = 0; i < length;) { // increment intentionally omitted
			final int cp = str.codePointAt(i);
			//System.out.println("cp:"+cp);
			i += Character.charCount(cp); // increment based on code point
			seen = charHash.get(cp);
			//System.out.println("seen:"+seen);
			if (seen == null) { // not present
				charHash.put(cp, seenOnce);
			} else {
				if (seen == seenOnce) {
					charHash.put(cp, seenMultiple);
				}
			}
		}
		// Search hash table in order of str
		for (i = 0; i < length;) {
			final int cp = str.codePointAt(i);
			i += Character.charCount(cp);
			if (charHash.get(cp) == seenOnce) {
				return new String(Character.toChars(cp));
			}
		}
		return null;
	}
	
	public static Character firstNonRepeatedAscii(String str) {
		HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();
		int i, length;
		Character c;
		length = str.length();
		// Scan str, building hash table
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			if (charHash.containsKey(c)) {
				// Increment count corresponding to c
				charHash.put(c, charHash.get(c) + 1);
			} else {
				charHash.put(c, 1);
			}
		}
		// Search hash table in order of str
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			if (charHash.get(c) == 1)
				return c;
		}
		return null;
	}
	
	public static String removeChars(String str, String remove) {
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		int src, dst = 0;
		// flags automatically initialized to false, size of 128 assumes ASCII
		boolean[] flags = new boolean[128];
		// Set flags for characters to be removed
		for (src = 0; src < r.length; ++src) {
			flags[r[src]] = true;
		}
		
		for(src=0;src<flags.length;src++){
			System.out.println("\n"+flags[src]+":"+src);
		}
		// Now loop through all the characters,
		// copying only if they aren’t flagged
		for (src = 0; src < s.length; ++src) {
			if (!flags[s[src]]) {
				s[dst++] = s[src];
			}
		}
		return new String(s, 0, dst);
	}
	
	public static String reverse ( String s ) {
        int length = s.length(), last = length - 1;
        char[] chars = s.toCharArray();
        for ( int i = 0; i < length/2; i++ ) {
            char c = chars[i];
            chars[i] = chars[last - i];
            chars[last - i] = c;
        }
        return new String(chars);
    }
	
	public static void breakIntoSpaces(String source){
		Hashtable<Integer,String> dictionary=new Hashtable<Integer,String>();
		dictionary.put(0,"peanut");
		dictionary.put(1,"butter");
		
		for(int i=1;i<source.length();i++){
			String left=source.substring(0, i);
			String right=source.substring(i, source.length());
			if(dictionary.containsValue(left) && dictionary.containsValue(right))
				System.out.println(left+" "+right);
		}
	}
	
	public static boolean hasSubstring(String srcStr,String findStr){
		char[] srcStrArr=srcStr.toCharArray();
		char[] findStrArr=findStr.toCharArray();
		boolean found=false;
		for(int i=0;i<srcStr.length();i++){
			found=false;
			for(int j=0;j<findStr.length();j++){
				if(srcStrArr[i+j]!=findStrArr[j]){
					found=true;
					break;
				}
			}
			if(!found){
				return true;
			}
		}
		return false;
		
	}
	
	public static int findDistanceBetweenWords(String inputBody, String pair1, String pair2) {
		
		if (inputBody.isEmpty() || pair1.isEmpty() || pair2.isEmpty()) {
			return -1;
		}
		
		if (pair1.equals(pair2)) {
			return 0;
		}
		
		StringTokenizer stringTokenizer = new StringTokenizer(inputBody, " ");
		int distance = 0, globalDistance = Integer.MAX_VALUE;
		String token;
		while (stringTokenizer.hasMoreTokens()) {
			token = stringTokenizer.nextToken();
			if (token.equals(pair1)) {
				distance = 0;
			} else if (token.equals(pair2)) {
				globalDistance = Math.min(distance, globalDistance);
			}
			distance++;
		}
		
		if (globalDistance == Integer.MAX_VALUE || globalDistance == 0) {
			return -1;
		} else {
			return globalDistance;
		}
		
	}

	

}
