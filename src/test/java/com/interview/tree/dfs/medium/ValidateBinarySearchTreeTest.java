package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {
    @Test
    public void testFlatten() {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode binaryTreeRoot = new TreeNode(2);
        binaryTreeRoot.left = new TreeNode(1);
        binaryTreeRoot.right = new TreeNode(3);


        boolean actualResult = validateBinarySearchTree.isValidBST(binaryTreeRoot);

        Assert.assertEquals(true, actualResult);


    }
}
