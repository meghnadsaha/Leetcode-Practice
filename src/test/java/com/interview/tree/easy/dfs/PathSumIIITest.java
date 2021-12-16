package com.interview.tree.easy.dfs;

import com.interview.tree.common.TreeNode;
import com.interview.tree.medium.dfs.PathSumIII;
import org.junit.Assert;
import org.junit.Test;

public class PathSumIIITest {
    @Test
    public void testPathSum() {
        PathSumIII pathSumIII = new PathSumIII();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);
        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);

        int actualOutput = pathSumIII.pathSum(root, 8);

        Assert.assertEquals(3, actualOutput);
    }
}
