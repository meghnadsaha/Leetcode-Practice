package com.interview.tree.easy;

import com.interview.tree.common.TreeNode;
import com.interview.tree.dfs.easy.InvertBinaryTree;
import org.junit.Assert;
import org.junit.Test;

public class InvertBinaryTreeTest {

    @Test
    public void testInvertTreeUsingDFS() {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);

        TreeNode actualOutput = invertBinaryTree.invertTreeUsingDFS(root);

       // Assert.assertEquals(true, actualOutput);
    }
}
