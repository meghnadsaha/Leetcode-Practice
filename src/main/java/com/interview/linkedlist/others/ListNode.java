package com.interview.linkedlist.others;

import java.util.Objects;

/*
 * Definition for singly-linked list.
 * */
public class ListNode {

    public int val;
    public ListNode next;
    public Node random;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode listNode) {

        if (listNode == null)
            System.out.print("null");
        while (listNode.next != null) {
            System.out.print(listNode.val + " → ");
            listNode = listNode.next;
        }
        System.out.print(listNode.val);
    }

    public void push(int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = random;
        random = new_node;
    }

    public static ListNode push(int[] llElements) {
        ListNode listNodeHead = null;
        for (int i = llElements.length - 1; i >= 0; i--) {
            listNodeHead = new ListNode(llElements[i], listNodeHead);
        }
        return listNodeHead;
    }


}
