package com.interview.tree.dfs.medium;

import com.interview.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    int depth = 0;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return ans;
        depth++;
        if (ans.size() < depth)
            ans.add(root.val);

        ans = rightSideView(root.right);
        ans = rightSideView(root.left);
        depth--;

        return ans;
    }
}
