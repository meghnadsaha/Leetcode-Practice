package com.interview.tree.fundamentals.level0;


import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data, null, null);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    public static void postorderTraversal(Node root) {

        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }


    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static int heightOfABinaryTree(Node root) {
        // Write your code here

        if (root == null) {
            return -1;
        }
        return Math.max(heightOfABinaryTree(root.left), heightOfABinaryTree(root.right)) + 1;
    }

    public static void topView(Node root) {
        if (root.left != null) {
            printLeft(root.left);
        }

        System.out.print(root.data);
        if (root.right != null) {
            System.out.print(" ");
        }

        if (root.right != null) {
            printRight(root.right);
        }
    }

    static void printLeft(Node root) {
        if (root.left != null) {
            printLeft(root.left);
        }
        System.out.print(root.data);
        System.out.print(" ");
    }

    static void printRight(Node root) {
        System.out.print(root.data);
        if (root.right != null) {
            System.out.print(" ");
        }
        if (root.right != null) {
            printRight(root.right);
        }
    }


    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            System.out.print(tmp.data);
            System.out.print(" ");
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }


    public static Node lowestCommonAncestorOfTwoNodesInATree(Node root, int v1, int v2) {
        while (root != null) {
            if (root.data > v1 && root.data > v2) {
                root = root.left;
            } else if (root.data < v1 && root.data < v2) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }



}
