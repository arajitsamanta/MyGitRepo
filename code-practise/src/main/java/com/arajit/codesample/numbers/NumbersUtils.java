package com.arajit.codesample.numbers;

public class NumbersUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("Addition:"+add(5,6));

		// System.out.println("Multiply:"+multiply(5,6));

		/*
		 * for (int i = 0; i < 10; i++) { System.out.print(fib(i) + ", "); }
		 * System.out.println(fib(10));
		 */
		//int[] arr = { 1, 2, 3, 4, 5 };
		//System.out.println(largestInArray(arr));
		formatRGB(255,128,255);
	}

	static int add(int x, int y) {
		if (y == 0)
			return x;
		else
			return add(x ^ y, (x & y) << 1);
	}

	static int multiply(int x, int y) {
		int result = 0;
		while (y != 0) // Iterate the loop till b==0
		{
			if ((y & 01) == 1) // Bitwise & of the value of b with 01
			{
				result = add(result, x); // Add a to result if b is odd .
			}
			x <<= 1; // Left shifting the value contained in 'a' by 1
						// multiplies a by 2 for each loop
			y >>= 1; // Right shifting the value contained in 'b' by 1.
		}
		return result;
	}

	int addWithoutRecurson(int x, int y) {
		// Iterate till there is no carry
		while (y != 0) {
			// carry now contains common set bits of x and y
			int carry = x & y;

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;

			// Carry is shifted by one so that adding it to x gives the required
			// sum
			y = carry << 1;
		}
		return x;
	}

	static long fib(int n) {
		return n <= 1 ? n : fib(n - 1) + fib(n - 2);
	}

	public static int largestInArray(int[] input) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max)
				max = input[i];
		}
		return max;
	}

	public static String formatRGB(int r, int g, int b) {
		return (toHex(r) + toHex(g) + toHex(b)).toUpperCase();
	}

	public static String toHex(int c) {
		String s = Integer.toHexString(c);
		return (s.length() == 1) ? "0" + s : s;
	}
	
	public static int secondMax(int[] arr) throws Exception {
		if (arr.length < 2) {
			throw new Exception("Invalid no of arguments");
		}
		int firstSmallest = arr[0];
		int secondSmallest = arr[1];
		for (int idx = 2; idx < arr.length; idx++) {
			if (arr[idx] < firstSmallest) {
				secondSmallest = firstSmallest;
				firstSmallest = arr[idx];
			} else if (arr[idx] < secondSmallest) {
				secondSmallest = arr[idx];
			}
		}
		return secondSmallest;
	}


}
