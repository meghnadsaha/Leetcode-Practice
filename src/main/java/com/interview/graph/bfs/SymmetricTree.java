package com.interview.graph.bfs;

import com.interview.binarysearch.TreeNode;
	
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null)
			return t1 == t2;

		return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
	}
}