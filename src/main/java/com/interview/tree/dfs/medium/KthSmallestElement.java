package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;

public class KthSmallestElement {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;

        // search in left subtree
        int  left = kthSmallest(root.left, k);

        // if k'th smallest is found in left subtree, return it
        if (left != 0)
            return left;

        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root.val;

        // else search in right subtree
        return kthSmallest(root.right, k);
    }
}
