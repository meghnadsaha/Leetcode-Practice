package com.interview.dynamic.programming.others;

import java.util.Arrays;

public class DungeonGame_174 {
	 public int calculateMinimumHP(int[][] dungeon) {
	        // corner case
	        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
	            return 0;
	        }
	        
	        // M[i][j] represents the health when I reach dungeon[i][j]
	        int m = dungeon.length;
	        int n = dungeon[0].length;
	        int[][] M = new int[m][n];
	        // initialization:
	        // M[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);  
	        // or M[m - 1][n - 1] = dungeon[i][j] >= 0? 1 : -dungeon[i][j] + 1;
	        // induction rule:
	        // M[i][n - 1] = max(M[i + 1][n - 1] - dungeon[i][n - 1], 1)
	        // M[m - 1][j] = max(M[m - 1][j + 1] - dungeon[m - 1][j], 1)
	        // M[i][j] = min(max(M[i][j + 1] - dungeon[i][j], 1), max(M[i + 1][j] - dungeon[i][j], 1))
	        for(int i = m - 1; i >= 0; i--){
	            for(int j = n - 1; j >= 0; j--){
	                if(i == m - 1 && j == n - 1){
	                    M[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]); 
	                }else if(i == m - 1){
	                    M[m - 1][j] = Math.max(M[m - 1][j + 1] - dungeon[m - 1][j], 1);
	                }else if(j == n - 1){
	                    M[i][n - 1] = Math.max(M[i + 1][n - 1] - dungeon[i][n - 1], 1);
	                }else{
	                    M[i][j] = Math.min(Math.max(M[i + 1][j] - dungeon[i][j], 1), Math.max(M[i][j + 1] - dungeon[i][j], 1));
	                }
	            }
	        }
	        
	        return M[0][0];
	    }
	
}

