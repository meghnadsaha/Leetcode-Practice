package com.interview.dynamic.programming;

import java.util.*;

public class OddEvenJump_975 {
	public static int oddEvenJumps(int[] A) {
		int n = A.length;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(A[n - 1], n - 1);

		boolean[] odd = new boolean[n];
		boolean[] even = new boolean[n];
		odd[n - 1] = true;
		even[n - 1] = true;

		for (int i = n - 2; i >= 0; i--) {
			Map.Entry oddEntry = map.ceilingEntry(A[i]);
			Map.Entry evenEntry = map.floorEntry(A[i]);

			if (oddEntry != null) {
				odd[i] = even[(int) oddEntry.getValue()]; //?
			}

			if (evenEntry != null) {
				even[i] = odd[(int) evenEntry.getValue()];
			}

			map.put(A[i], i);
		}

		int res = 0;
		for (boolean b : odd) {
			if (b)
				res++;// Check how many value in odd array are true
		}

		return res;
	}
	public static void main(String args[]){
		int array[] = {5,1,3,4,2};
		int array1[] = {2,3,1,1,4};

		System.out.println(oddEvenJumps(array));
	}
	
}
