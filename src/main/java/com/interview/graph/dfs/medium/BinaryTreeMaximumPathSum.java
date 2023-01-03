package com.interview.graph.dfs.medium;

import com.interview.binarysearch.TreeNode;
	
public class BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		maxPathSumDfs(root, max);
		return max[0];
	}

	private int maxPathSumDfs(TreeNode t, int[] max) {
		if (t == null)
			return 0;

		int l = maxPathSumDfs(t.left, max) + t.val;
		int r = maxPathSumDfs(t.right, max) + t.val;
		int localMax = (l > r) ? Math.max(l, t.val) : Math.max(r, t.val);
		int mergedPaths = l + r - t.val;

		max[0] = Math.max(max[0], mergedPaths);
		max[0] = Math.max(max[0], localMax);

		return localMax;
	}
}
