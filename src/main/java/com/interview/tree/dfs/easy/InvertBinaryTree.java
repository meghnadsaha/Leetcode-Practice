package com.interview.tree.dfs.easy;


import com.interview.tree.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public TreeNode invertTreeUsingDFS(TreeNode root) {//recursive DFS
        if (root == null)
            return null;
        TreeNode tempRight = root.right;
        root.right = invertTreeUsingDFS(root.left);
        root.left = invertTreeUsingDFS(tempRight);
        return root;
    }


    public TreeNode invertTreeUsingBfs(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

}