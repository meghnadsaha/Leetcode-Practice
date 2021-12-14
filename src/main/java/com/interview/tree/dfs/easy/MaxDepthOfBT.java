package com.interview.tree.dfs.easy;


import com.interview.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The maximum depth of a binary tree is the number of nodes from the root down to the furthest leaf node.
 * In other words, it is the height of a binary tree.
 *         1
 *        / \
 *       /   \
 *      /     \
 *     2       3
 *    /       / \
 *   4       5   6
 *           \   /
 *            7 8
 *  The maximum depth, or height, of this tree is 44;
 *  node 77 and node 88 are both four nodes away from the root.
 */
public class MaxDepthOfBT {
    /**
     * Two stacks are used for the DFS one.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);//1*
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();//20RT->(15L-7R)//7RT->(null.L-null.R)
            int temp = value.pop();//2 , 3 ,3
            max = Math.max(temp, max);//M(1,2)//m(2,3)
            if (node.left != null) {
                stack.push(node.left);//9L //15RT->(null.L-null.R)
                value.push(temp + 1);//1(Refer line:22) 2, 3
            }
            if (node.right != null) {
                stack.push(node.right);//20RT->(15L-7R) //7RT->(null.L-null.R)
                value.push(temp + 1);//1(Refer line:22) 2, 3
            }
        }
        return max;
    }

    /**
     * A Queue for the level-order traversal one.
     * Level order one is faster.
     * BFS
     */
    public int maxDepthUsingBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
