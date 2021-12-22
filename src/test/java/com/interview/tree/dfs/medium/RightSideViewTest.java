package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSideViewTest {
    @Test
    public void testRightSideView1() {
        RightSideView rightSideView = new RightSideView();
        TreeNode binaryTreeRoot = new TreeNode(1);
        binaryTreeRoot.left = new TreeNode(2);
        binaryTreeRoot.right = new TreeNode(5);

        binaryTreeRoot.left.left = new TreeNode(3);
        binaryTreeRoot.left.right = new TreeNode(4);

        binaryTreeRoot.right.right = new TreeNode(6);


        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 5, 6));
        List<Integer> actualResult = rightSideView.rightSideView(binaryTreeRoot);

        int count = 0;
        int depthOfTree = 3;
        while (actualResult.size() < depthOfTree) {
            Assert.assertEquals(actualResult.get(count), expectedResult.get(count));
            count++;
        }
    }

    @Test
    public void testRightSideView() {
        RightSideView rightSideView = new RightSideView();
        TreeNode binaryTreeRoot = new TreeNode(1);
        binaryTreeRoot.left = new TreeNode(2);
        binaryTreeRoot.left.left = new TreeNode(2);


        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 2, 2));
        List<Integer> actualResult = rightSideView.rightSideView(binaryTreeRoot);

        int count = 0;
        int depthOfTree = 3;
        while (actualResult.size() < depthOfTree) {
            Assert.assertEquals(actualResult.get(count), expectedResult.get(count));
            count++;
        }
    }
}
