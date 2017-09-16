/**
 * 
 */
package com.arajit.crack.code.recursion;

/**
 * @author as47775
 *
 */
public class Fibonacci {
	
	int fibonacci(int n){		
		if(n==0)	return 0;
		if(n==1)	return 1;
		
		return fibonacci(n-1) + fibonacci(n-2); 
	}
	
	
	int fibonacciMemorized(int n){		
		return fibonacciMemorized(n, new int[n+1]); 
	}

	
	int fibonacciMemorized(int n, int[] memo) {
		if (n == 0 ||  n== 1)
			return n;

		if (memo[n] == 0) {
			memo[n] = fibonacciMemorized(n - 1, memo) + fibonacciMemorized(n - 2, memo);
		}
		
		return memo[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci fibgenerator=new Fibonacci();		
		System.out.println("N'th fibonacci no is -> "+fibgenerator.fibonacci(10));
		
		System.out.println("N'th fibonacci no using Dynamic programming No is -> "+fibgenerator.fibonacciMemorized(3));
	}

}
