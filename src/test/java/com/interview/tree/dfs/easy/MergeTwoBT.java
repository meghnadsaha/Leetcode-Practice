package com.interview.tree.dfs.easy;

import com.interview.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBT {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            if (node1 == null || node2 == null) {
                continue;
            }

            if (null != node2) {
                node1.val += node2.val;
            }

            if (null == node1.left && null != node2) {
                node1.left = node2.left;
            } else {
                q1.add(node1.left);
                if (null != node2) {
                    q2.offer(node2.left);
                }
            }

            if (null == node1.right && null != node2) {
                node1.right = node2.right;
            } else {
                q1.add(node1.right);
                if (null != node2) {
                    q2.offer(node2.right);
                }
            }
        }

        return root1;
    }

    public TreeNode mergeTreesUsingDFS(TreeNode rooroot1, TreeNode root2)
    {//Postorder Traversal
        if(rooroot1 == null)//when we see that the rooroot1 is null there is a possibility that root2 is not null so we return that and maintaining the link and continue overlapping
            return root2;//telling that rooroot1 is not present so sending rooroot1

        if(root2 == null)//when we see that the root2 is null there is a possibility that rooroot1 is not null so we return that and maintaining the link
            return rooroot1;//telling that root2 is not present so sending rooroot1

        //LEFT - RIGHT
        TreeNode left= mergeTrees(rooroot1.left, root2.left);//recursing down the left subtree and knowing about the left child
        TreeNode right= mergeTrees(rooroot1.right, root2.right);//recursing down the right subtree and knowing about the right child

        //ROOT
        //creating the node by the total information received from left and right child
        TreeNode node= new TreeNode(rooroot1.val+root2.val, left, right);

        return node;//returning the node in order to maintain the backward modified link at each instant//Telling to the parent that I am present
    }
}
