package com.interview.tree;

public class UniqueBinarySearchTrees {

	/**
	 * Then idea is to make each number i , 1<= i <=n root of the tree , then
	 * the left subtree should be formed from numbers [1,i-1]
	 * 
	 * and right subtree from [i+1,n]so f(i,j) = summation of  f(i,x-1)* f(x+1,j) for i<=x<=j
	 * 
	 * dp[i][j] indicated number of ways to form binary search tree with numbers from i to j
	 *  (both inclusive)
	 */

	public int numTrees(int n) {
        if(n<1)
        return 0;
        int[][] dp=new int[n+1][n+1];
		return f(1,n,dp);
    }
    public int f(int i,int j,int[][] dp){
		if(i==j || i>j) return 1;
		if(dp[i][j]!=0) return dp[i][j];
		int sum=0;
		for(int x=i;x<=j;x++){
			sum+=f(i,x-1,dp)*f(x+1,j,dp);
		}
		dp[i][j]=sum;
		return dp[i][j];
	}
}
