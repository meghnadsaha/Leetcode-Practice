package com.interview.tree.dfs;


import com.interview.binarysearch.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;

    //this variable will be used to store the result after each possible path and hence will finally store the max  path sum
    public int maxPathSum(TreeNode root) {
        if (root == null) return res;
        dfs(root);      //this will update the value or res as required
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;   //base case and very imp

        //at any node we want to find the left and right side max Sum
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        // we are finding the max with 0 as we do not want to include any subtree with negative contributiuon. See explaination above


        //left here is storing the max possible contribution of the left subtree
        //right here is storing the max possible contribution of right subtree
        //if either of left and rigth have a possitive contribution(value), the larger will finally be taken

        //but first we will have to assume that the subtree with root node as root(the variable in this function) will have the largest sum path, so we will inlude this in our res if it has a value larger than previous res
        res = Math.max(res, root.val + left + right);


        //the function however is expected to return the contribution of the current subtree if the subtree was include as in case 1 explained above. It it was terminating here, left and right would have value 0
        //so we simply return the sum of the root val and the larger between left and rigth subtree sum
        return root.val + Math.max(left, right);

    }
} //do upvote if this helps

