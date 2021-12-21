package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;
import com.interview.tree.dfs.medium.dfs.LowestCommonAncestorOfATree;
import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorOfATreeTest {
    @Test
    public void testPathSum() {
        LowestCommonAncestorOfATree lcs = new LowestCommonAncestorOfATree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.left = new TreeNode(4);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        TreeNode actualOutput = lcs.lowestCommonAncestor(root,p,q);

        Assert.assertEquals(3, actualOutput.val);
    }
}