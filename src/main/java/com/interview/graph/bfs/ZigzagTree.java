package com.interview.graph.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

import com.interview.binarysearch.TreeNode;

public class ZigzagTree {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> output = new LinkedList<>();
		if (root == null)
			return output;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		LinkedList<Integer> temp;
		boolean reverse = false;

		while (!q.isEmpty()) {
			temp = new LinkedList<>();
			for (int i = q.size(); i > 0; --i) {
				TreeNode curr = q.poll();
				if (reverse) {
					temp.addFirst(curr.val);
				} else {
					temp.add(curr.val);
				}
				if (curr.left != null)
					q.offer(curr.left);
				if (curr.right != null)
					q.offer(curr.right);
			}
			reverse = (reverse == true) ? false : true;
			output.add(temp);
		}
		return output;

	}
}