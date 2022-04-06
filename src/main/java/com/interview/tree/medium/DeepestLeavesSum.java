package com.interview.tree.medium;

import com.interview.tree.common.TreeNode;

public class DeepestLeavesSum {
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        int MaxDepth = maxDepth(root);

        return helper(root, MaxDepth);
    }

    public static int maxDepth(TreeNode node) {
        // base case
        if (node == null)
            return 0;

        // either leftDepth of rightDepth is
        // greater add 1 to include height
        // of node at which call is
        return 1 + Math.max(maxDepth(node.left),
                maxDepth(node.right));
    }


    public int helper(TreeNode root, int sum) {

        if (root == null)
            return 0;

        // sum == 1 to track the node
        // at deepest level
        if (sum == 1)
            return root.val;

        // recursive call to left and right nodes
        return helper(root.left, sum - 1) + helper(root.right, sum - 1);
    }

}