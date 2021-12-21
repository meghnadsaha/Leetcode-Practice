package com.interview.tree.dfs.medium.dfs;

import com.interview.tree.common.TreeNode;

public class FlattenBinaryTreeToLL {
    private TreeNode prev = null;

    public TreeNode flatten(TreeNode root) {
        if (root == null)
            return root;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

        return prev;
    }
}