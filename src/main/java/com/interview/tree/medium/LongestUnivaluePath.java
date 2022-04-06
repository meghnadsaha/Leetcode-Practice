package com.interview.tree.medium;

import com.interview.tree.common.TreeNode;

public class LongestUnivaluePath {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {

        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        // Recursive calls to check for subtrees
        int left = helper(root.left);
        int right = helper(root.right);

        // Variables to store maximum lengths
        // in two directions
        int Leftmax = 0, Rightmax = 0;

        // If curr root and it's left child
        // has same value
        if (root.left != null &&
                root.left.val == root.val)
            Leftmax += left + 1;

        // If curr root and it's right child
        // has same value
        if (root.right != null &&
                root.right.val == root.val)
            Rightmax += right + 1;

        ans = Math.max(ans, Leftmax + Rightmax);
        return Math.max(Leftmax, Rightmax);
    }

}
