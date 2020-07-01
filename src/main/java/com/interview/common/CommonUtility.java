package com.interview.common;

import java.util.Arrays;

public class CommonUtility {
	
	  public static void print2D(int mat[][]) 
	    { 
	        // Loop through all rows 
	        for (int[] row : mat) 
	  
	            // converting each row as string 
	            // and then printing in a separate line 
	            System.out.println(Arrays.toString(row)); 
	    } 
}
