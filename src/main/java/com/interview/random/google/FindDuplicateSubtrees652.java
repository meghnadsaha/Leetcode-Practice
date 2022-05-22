package com.interview.random.google;

import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class FindDuplicateSubtrees652 {


    TreeNode root;

    static int currId = 1;

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> serialToId = new HashMap<>();
        Map<Integer, Integer> idToCount = new HashMap<>();

        List<TreeNode> res = new LinkedList<>();
        postOrder(root, serialToId, idToCount, res);

        return res;

    }


    private static int postOrder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
        if (root == null) return 0;

        int leftId = postOrder(root.left, serialToId, idToCount, res);
        int rightId = postOrder(root.right, serialToId, idToCount, res);

        String currentSerial = leftId + "," + root.val + "," + rightId;
        int serialId = serialToId.getOrDefault(currentSerial, currId);
        if (serialId == currId) {
            currId++;
        }
        serialToId.put(currentSerial, serialId);
        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
        if (idToCount.get(serialId) == 2) res.add(root);

        return serialId;


    }

    public static void main(String[] args) {
        FindDuplicateSubtrees652 tree = new FindDuplicateSubtrees652();
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(1);


        List<TreeNode> children = findDuplicateSubtrees(tree.root);
        for (TreeNode child : children) {
            System.out.println(child.val);
        }
        children.stream().forEach(p -> System.out.println(p.val));

    }
}