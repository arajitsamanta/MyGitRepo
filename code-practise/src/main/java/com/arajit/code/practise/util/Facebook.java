package com.arajit.code.practise.util;

import java.util.ArrayList;

public class Facebook {

	ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			B.add(new ArrayList<Integer>());

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).add(0);
			}

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
			}
		}
		return B;
	}
	
	public static int numSetBits(long a) {
        int count = 0;
        while (a != 0){
            count += a & 1;
            a >>= 1;
        }
        return count;
    }

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> B = performOps(A);
		for (int i = 0; i < B.size(); i++) {
		    for (int j = 0; j < B.get(i).size(); j++) {
		            System.out.print(B.get(i).get(j) + " ");
		    }
		}*/
		System.out.println("digit::"+numSetBits(11));
	}

}
