package com.arajit.codesample.numbers;

public class BitwiseUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//isNthBitSet(5, 1);
		//setNthBitSet(5, 1);
																																																																																																																																																																																																																																																																																																																															
		
	}

	public static void oddEven(int x) {
		if ((x & 1) == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	}
	
	public static void isNthBitSet(int x,int n){
		if ((x & (1<<n))!=0) {
			System.out.println(n +"-th bit is set");
		}
		else {
			System.out.println(n+"-th bit is not set");
		}
	}
	
	public static void setNthBitSet(int x,int n){
		int y = x | (1<<n);
		System.out.println("Y:"+y);
	}
	
	public static void unsetNthBitSet(int x,int n){
		int y = x & ~(1<<n);
		System.out.println("Y:"+y);
	}
	
	public static void toggleNthBitSet(int x,int n){
		int y = x ^ (1<<n);
		System.out.println("Y:"+y);	
	}
	
	public static void turnOffRightMost1Bit(int x){
		int y = x & (x-1);
		System.out.println("Y:"+y);
	}


}
