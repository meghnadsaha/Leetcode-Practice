package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {
    @Test
    public void testFlatten() {
        FlattenBinaryTreeToLL flattenBinaryTreeToLL = new FlattenBinaryTreeToLL();
        TreeNode binaryTreeRoot = new TreeNode(1);
        binaryTreeRoot.left = new TreeNode(2);
        binaryTreeRoot.right = new TreeNode(5);

        binaryTreeRoot.left.left = new TreeNode(3);
        binaryTreeRoot.left.right = new TreeNode(4);

        binaryTreeRoot.right.right = new TreeNode(6);

        TreeNode binaryTreeRootAlisLinkedListHereRoot = new TreeNode(1);
        binaryTreeRootAlisLinkedListHereRoot.left = null;
        binaryTreeRootAlisLinkedListHereRoot.right = new TreeNode(2);

        binaryTreeRootAlisLinkedListHereRoot.right.left = null;
        binaryTreeRootAlisLinkedListHereRoot.right.right = new TreeNode(3);

        binaryTreeRootAlisLinkedListHereRoot.right.right.left = null;
        binaryTreeRootAlisLinkedListHereRoot.right.right.right = new TreeNode(4);

        binaryTreeRootAlisLinkedListHereRoot.right.right.right.left = null;
        binaryTreeRootAlisLinkedListHereRoot.right.right.right.right = new TreeNode(5);


        binaryTreeRootAlisLinkedListHereRoot.right.right.right.right.left = null;
        binaryTreeRootAlisLinkedListHereRoot.right.right.right.right.right = new TreeNode(6);


        TreeNode expectedResult = binaryTreeRootAlisLinkedListHereRoot;
        TreeNode actualResult = flattenBinaryTreeToLL.flatten(binaryTreeRoot);

        while (actualResult != null && actualResult.right != null) {
            Assert.assertEquals(actualResult.right.val, expectedResult.right.val);
            actualResult = actualResult.right;
            expectedResult = expectedResult.right;
        }


    }
}
