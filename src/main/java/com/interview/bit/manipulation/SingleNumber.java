package com.interview.bit.manipulation;

public class SingleNumber {
	  public int singleNumber(int[] array) {
	        int result = 0;
	        for (int num : array) {
	            result = result ^ num; // ^ is XOR operator
	        }
	        return result;
	    }
}
