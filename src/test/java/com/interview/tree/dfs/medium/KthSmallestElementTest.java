package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class KthSmallestElementTest {

    @Test
    public void testPathSum() {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);

        int actualOutput = kthSmallestElement.kthSmallest(root, 1);

        Assert.assertEquals(1, actualOutput);
    }

    @Test
    public void testPathSum2() {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        int actualOutput = kthSmallestElement.kthSmallest(root, 3);

        Assert.assertEquals(3, actualOutput);
    }
}
