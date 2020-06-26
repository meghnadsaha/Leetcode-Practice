package com.interview.dynamic.programming;

import java.util.Arrays;

public class MaximumSumof3NonOverlappingSubarrays_689 {

	  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
	        int len = nums.length;
	        int n = len - k + 1;
	        int dp[] = new int[n];
	        int sum = 0;
	        for (int i= 0 ;i < len ; i++){
	            //prefix sum
	            //get continuous len:k sum array 
	            sum += nums[i];
	        
	        
	        //Out of window case check , k = 3
	        //0,1,2
	        //remove them from sum[]
	        if(i >= k){
	            sum -= nums[i - k]; //-------------> sum
	        }                                  //   |
	                                           //   |
	                                           //   |
	        //And save the index in dp[] array //   |
	        if(i >= k - 1){                    //   |
	            dp[i - k + 1] = sum;  //<------------
	        }  
	    }
	        int [] left = new int[n];
	        int [] right = new int[n];
	        int maxIndex = 0;
	        
	        //left[n] --> till here the max len :k subarray O(n)
	        for(int i =0; i<n ;i++){
	            if(dp[i] > dp[maxIndex]){
	                maxIndex = i;
	            }
	            left[i] = maxIndex ;                
	        }
	        
	        
	        //right[n] --> till here the max len :k subarray O(n)
	        maxIndex = n -1 ;
	        for(int i = n -1 ; i >= 0 ;i--){
	            // >= bcs if they have same value, I have the  smaller index 
	            if(dp[i] >= dp[maxIndex]){
	                maxIndex = i;
	            }
	            right[i] = maxIndex ;                
	        }
	        
	        int[] res  = new int[3];
	        Arrays.fill(res,-1);
	        
	        //bcs we left "K" element in left side and 2 in right
	        for(int i =k ; i< n-k ;i++){
	            if(res[0]==-1 
	                ||
	               dp[res[0]]    + dp[res[1]] + dp[res[2]]  
	                <
	               dp[left[i-k]] + dp[i]      + dp[right[i+k]])
	            {
	             res[0] = left[i - k];
	                
	             res[1] = i;
	                
	             res[2] = right[i + k];
	                
	            }
	            
	        }        
	        return res;
	    }
	}