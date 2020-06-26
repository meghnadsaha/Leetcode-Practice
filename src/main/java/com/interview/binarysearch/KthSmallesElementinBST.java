package com.interview.binarysearch;

public class KthSmallesElementinBST {
	public int kthSmallest(TreeNode root, int k) {
		while (root != null) {
			if (root.left == null) {
				k -= 1;
				if (k == 0)
					return root.val;
				root = root.right;
			} else {
				TreeNode pred = root.left;
				while (pred.right != null && pred.right != root) {
					pred = pred.right;
				}
				if (pred.right == null) {
					pred.right = root;
					root = root.left;
				} else {
					k -= 1;
					if (k == 0)
						return root.val;
					root = root.right;
					pred.right = null;
				}
			}
		}
		throw new IllegalArgumentException("No Solution");
	}
}
