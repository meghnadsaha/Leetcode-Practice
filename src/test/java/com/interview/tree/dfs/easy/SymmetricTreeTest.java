package com.interview.tree.dfs.easy;

import com.interview.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SymmetricTreeTest {

    @Test
    public void testIsSymmetric() {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean actualOutput = symmetricTree.isSymmetric(root);

        Assert.assertEquals(true,actualOutput);
    }

//    @Test
//    public void testMaxDepthOfBinaryTree() {
//        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//
//        int actualOutput = maxDepthOfBinaryTree.maxDepth(root);
//
//        Assert.assertEquals(3,actualOutput);
//    }


}
