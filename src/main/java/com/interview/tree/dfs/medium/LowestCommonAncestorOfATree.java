package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorOfATree {

    List<TreeNode> path;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path = new LinkedList();
        findPath(root, p, path);
        List<TreeNode> path1 = path;
        path = new LinkedList();
        findPath(root, q, path);
        List<TreeNode> path2 = path;
        for (int i = 0; i < path1.size() && i < path2.size(); i++)
            if (path1.get(i).val == path2.get(i).val)
                root = path1.get(i);
        return root;
    }

    boolean findPath(TreeNode root, TreeNode f, List<TreeNode> path) {
        path.add(root);
        if (root.val == f.val) return true;
        if (root.left != null && findPath(root.left, f, path)) return true;
        if (root.right != null && findPath(root.right, f, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }
}