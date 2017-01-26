package com.arajit.codesample.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	private static String REGEX="<([a-zA-Z][a-zA-Z0-9]*)(()| [^>]*)>(.*)</\1>";
	private static String INPUT="<font size="+"2"+">Topcoder is the</font> <b>best</b>";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(INPUT);
		boolean found=false;
		while(matcher.find()) {
		  System.out.println("Found the text \"" + matcher.group() +  "\" starting at index " + matcher.start() +
		      " and ending at index " + matcher.end() + ".");
		  found = true;
		}

		if(!found){
		  System.out.println("No match found.");
		}
	}

}
