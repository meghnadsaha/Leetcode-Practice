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
            System.out.print(listNode.val + ".");
            listNode = listNode.next;
        }
        System.out.print(listNode.val);
    }

    public void push(int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = random;
        random = new_node;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        result = prime * result + val;
        return result;
    }


}
