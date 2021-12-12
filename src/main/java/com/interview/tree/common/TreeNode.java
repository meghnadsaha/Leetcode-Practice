package com.interview.tree.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    List<Integer> ans = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Preorder: Node -> Left -> Right
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return ans;
        ans.add(root.val);
        preorderTraversal(root.left);
        return preorderTraversal(root.right);
    }

    /**
     * Inorder : Left -> Node -> Right
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return ans;
        inorderTraversal(root.left);
        ans.add(root.val);
        return inorderTraversal(root.right);
    }

    /**
     * Postorder : Left -> Right -> Node
     *
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return ans;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ans.add(root.val);

        return ans;
    }
}