/**
 * 
 */
package com.arajit.crack.code.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author as47775
 * 
 * Problem:
 * =======
 * Write an algorithm to replace all spaces in a string with '%20'
 * 
 * Solution 1:
 * ==========
 * use String api's replace() method
 * 
 * Solution 2:
 * ==========
 * 1. Count no of spaces in the original string
 * 2. Create a char array whose length equals to original length of the string plus spaceCount*no of character to be replaced(In this case it is 3[%20])
 * 3. Copy individual characters from the original string to  the new character array one by one  and insert %20 when see a space. 
 */
public class URLify {
	
	public String replaceSpaces(String input){
		return input.replace(" ", "%20");
	}
	
	int countSpace(String str){
		int spaceCount=0;;
		for(int idx=0;idx<str.length();idx++){
			if(str.charAt(idx)==' ') 
				spaceCount++;
		}
		return spaceCount;
	}
	
	public String replaceSpacesNoAPI(String input){
		int spaces=countSpace(input);
		char[] charArr=new char[(input.length()-spaces)+(spaces*3)];
		int chArrIdx=0;
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)==' '){
				charArr[chArrIdx]='%';
				charArr[chArrIdx+1]='2';
				charArr[chArrIdx+2]='0';
				chArrIdx+=3;
			}else{
				charArr[chArrIdx]=input.charAt(i);
				chArrIdx++;
			}
			//HelperUtils.getInstance().displayCharArray(charArr);
			//display(charArr);
		}		
		return String.valueOf(charArr);
	}
	

	
	@Test
	public void replaceSpacesTest(){
		String str="Mr John Smith   is ";		
		System.out.println(replaceSpaces(str).length());
		System.out.println(replaceSpacesNoAPI(str).length());
		//replaceSpacesWithoutAPI(str);
		assertEquals(replaceSpaces(str),replaceSpacesNoAPI(str));
	}
	
}
