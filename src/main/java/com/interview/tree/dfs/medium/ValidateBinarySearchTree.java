package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long least, long max) {
        if (root == null)
            return true;
        if (root.left != null && (root.left.val >= root.val || root.left.val <= least))
            return false;
        if (root.right != null && (root.right.val <= root.val || root.right.val >= max))
            return false;
        return isValid(root.left, least, root.val) && isValid(root.right, root.val, max);
    }
}
