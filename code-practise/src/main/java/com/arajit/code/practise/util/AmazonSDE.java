package com.arajit.code.practise.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.lang.System;

public class AmazonSDE {
	

	public static void main(String[] args) {
        String braces = "{h[e{lo}!]}~()()()(";
        String braces1 = "[](){}<>";
        
        System.out.println(isBalanced(braces));
        
        /*if(isBalanced(braces)){
            System.out.println("YES");
        }else{   //System.out.print(isBalanced(braces1));
       
        int[][] maze1={{0,0,0,0},{1,0,1,0},{1,0,0,0}};
        findMinNumSteps(maze1,3,4,2,3);
        
        int[][] maze2={{0,0,0},{0,1,0},{0,0,0}};
        findMinNumSteps(maze2,3,3,2,1); */
    }

    private static int isBalanced(String str) {
        Map<Character, Character> bracketPairs = new HashMap<Character, Character>(){
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
                put('<', '>');
            }
        };

        if(str.length() % 2 != 0){
            return 0;
        }
        
        Stack<Character> halfBraces = new Stack<Character>();

        for(int i = 0; i < str.length(); i++){
            if(bracketPairs.containsKey(str.charAt(i))){
                halfBraces.push(str.charAt(i));
            }else if(halfBraces.isEmpty() || bracketPairs.get(halfBraces.pop()) != str.charAt(i)){
                return 0;
            }
        }
        return halfBraces.isEmpty() ? 1 : 0;
    }
    
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 	public static int findMinNumSteps(int[][] maze, int rows, int columns, int exitRow, int exitCol)
 	{
 		// WRITE YOUR CODE HERE
 		int countRow=0;
 		int countStep=-1;
 		for(int rowIdx=0;rowIdx<rows;rowIdx++){
 			
 			for(int colIdx=0;colIdx<columns;colIdx++){
 	 			if(rowIdx==exitRow && colIdx==exitCol){
 	 				System.out.println(countRow);
 	 				System.out.println("found"+(countRow+colIdx));
 	 				countStep=countRow+colIdx;
 	 				break;
 	 			} 	 			
 	 		}
 			
 			countRow=rowIdx+1;
 		}
 		
 		System.out.println("count::"+countStep);
 		return countStep;
 	}
 	// METHOD SIGNATURE ENDS
}
