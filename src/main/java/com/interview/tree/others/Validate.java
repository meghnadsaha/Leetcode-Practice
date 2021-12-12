package com.interview.tree.others;

import com.interview.binarysearch.TreeNode;

public class Validate {
	private TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {
		return isBSTUsinPrev(root, new TreeNode(-1));
	}

	public boolean isBSTUsinPrev(TreeNode root, TreeNode prevHolder) {
		if (root == null)
			return true;
		boolean left = isBSTUsinPrev(root.left, prevHolder);
		if (prevHolder.left != null) {
			if (prevHolder.left.val >= root.val)
				return false;
		}
		prevHolder.left = root;
		boolean right = isBSTUsinPrev(root.right, prevHolder);
		return left && right;
	}
}
