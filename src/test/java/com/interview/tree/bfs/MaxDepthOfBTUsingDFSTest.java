package com.interview.tree.bfs;

import com.interview.tree.common.TreeNode;
import com.interview.tree.dfs.easy.MaxDepthOfBT;
import org.junit.Assert;
import org.junit.Test;

public class MaxDepthOfBTUsingDFSTest {

    @Test
    public void testMaxDepth() {

        MaxDepthOfBT maxDepthOfBT = new MaxDepthOfBT();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int actualOutput = maxDepthOfBT.maxDepth(root);

        Assert.assertEquals(3, actualOutput);
    }
}
