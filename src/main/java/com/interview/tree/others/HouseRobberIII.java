package com.interview.tree.others;

import com.interview.binarysearch.TreeNode;

public class HouseRobberIII {
	private class NodeState {
		public int moneySelf;
		public int moneySon;

		public NodeState(int moneyself, int moneyson) {
			this.moneySelf = moneyself;
			this.moneySon = moneyson;
		}
	}

	public int rob(TreeNode root) {
		NodeState nodeState = robSearch(root);
		return Math.max(nodeState.moneySelf, nodeState.moneySon);
	}

	public NodeState robSearch(TreeNode root) {
		if (root == null) {
			NodeState tmp = new NodeState(0, 0);
			return tmp;
		}
		NodeState left;
		NodeState right;
		left = robSearch(root.left);
		right = robSearch(root.right);
		NodeState nodeState = new NodeState(root.val, 0);
		nodeState.moneySon = Math.max(left.moneySelf, left.moneySon) + Math.max(right.moneySelf, right.moneySon);
		nodeState.moneySelf += left.moneySon + right.moneySon;
		return nodeState;
	}
}
