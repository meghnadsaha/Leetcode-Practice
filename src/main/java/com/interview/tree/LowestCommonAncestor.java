package com.interview.tree;

import com.interview.binarysearch.TreeNode;

public class LowestCommonAncestor {

	 TreeNode x,y;
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        x=p;
	        y=q;
	        return dfs(root);
	    }
	    public TreeNode dfs(TreeNode root){
	        if(root==null)return null;
	        if(root==x || root==y)return root;
	        
	        TreeNode left=dfs(root.left);
	        TreeNode right=dfs(root.right);
	        
	        if(left!=null && right==null)return left;
	        else if(left==null && right!=null)return right;
	        else if(left!=null && right!=null)return root;
	        else return null;
	    }
}
