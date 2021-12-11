package com.interview.linkedlist.others;

public class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {//For Normal Nodes
        this.val = val;
        this.next = next;
    }

    public Node(int key, int val) { // For Hash-Map
        this.key = key;
        this.val = val;
    }
}	