package com.interview.tree;

import java.util.ArrayList;
import java.util.List;

import com.interview.binarysearch.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	List<List<Integer>> res = new ArrayList();

	public List<List<Integer>> levelOrder(TreeNode root) {
		levelOrderRec(root, 1);
		return res;
	}

	private void levelOrderRec(TreeNode root, int level) {
		if (root == null)
			return;
		if (res.size() < level)
			res.add(new ArrayList());
		res.get(level - 1).add(root.val);
		levelOrderRec(root.left, level + 1);
		levelOrderRec(root.right, level + 1);
	}
}
