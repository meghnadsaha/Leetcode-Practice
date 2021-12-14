package com.interview.linkedlist.medium;


import com.interview.linkedlist.others.Node;

import java.util.HashMap;

//https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43497/2-clean-C%2B%2B-algorithms-without-using-extra-arrayhash-table.-Algorithms-are-explained-step-by-step.
//https://leetcode.wang/leetcode-138-Copy-List-with-Random-Pointer.html

public class CopyListWithRandomPointer {
    public Node copyRandomListUsingMap(Node head) {
        // HashMap which holds old nodes as keys and new nodes as its values.
        HashMap<Node, Node> map = new HashMap<Node, Node>();

        //copy list nodes into hash table
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        //deep copy using hash table
        Node q = head;
        while (q != null) {
            map.get(q).next = map.get(q.next);
            map.get(q).random = map.get(q.random);
            q = q.next;
        }

        //return new head
        return map.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node l1 = head;
        Node l2 = null;
        //1. Generate all nodes and insert them behind the original nodes
        while (l1 != null) {
            l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1.next.next;
        }
        //2. Update the random of the inserted node
        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;
        }

        l1 = head;
        Node l2_head = l1.next;
        //3. Separate the old and new nodes
        while (l1 != null) {
            l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }
        return l2_head;
    }

}

