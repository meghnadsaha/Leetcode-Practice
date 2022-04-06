package com.interview.tree.medium;

import com.interview.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzagLevelOrder(root, 0);
        return res;
    }

    private void zigzagLevelOrder(TreeNode root, int level) {
        if (root == null)
            return;
        if (res.size() <= level)
            res.add(new ArrayList());

        if (level % 2 == 0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);

        zigzagLevelOrder(root.left, level + 1);
        zigzagLevelOrder(root.right, level + 1);
    }
}