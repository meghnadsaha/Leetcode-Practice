package com.interview.tree.medium.dfs;

import com.interview.tree.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=MHocw0bP1rA&t=241s
//https://www.youtube.com/watch?v=yyZA4v0x16w
public class PathSumIII {
    //0(n^2)
    public int pathSumON2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int findPath(TreeNode root, int sum) {
        int res = 0;
        if (root == null)
            return res;
        if (sum == root.val)
            res++;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;

    }

    //O(N)
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
        return backtrack(root, 0, sum, map);
    }
    //BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        int totalNoOfPath = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        totalNoOfPath += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        return totalNoOfPath;
    }
}
