package com.interview.tree.easy;

import com.interview.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        TreeNode treeNode = new TreeNode();
        List<Integer> nodes = new ArrayList<>();

        System.out.print("Preorder traversal of binary tree is:");
        nodes = treeNode.preorderTraversal(root);
        for (Integer node : nodes) {
            System.out.print(node + " ");
        }
        System.out.println();


        System.out.print("Inorder traversal of binary tree is:");
        nodes.clear();
        nodes = treeNode.inorderTraversal(root);
        for (Integer node : nodes) {
            System.out.print(node + " ");
        }
        System.out.println();


        System.out.print("Postorder traversal of binary tree is:");
        nodes.clear();
        nodes = treeNode.postorderTraversal(root);
        for (Integer node : nodes) {
            System.out.print(node + " ");
        }
    }

}
