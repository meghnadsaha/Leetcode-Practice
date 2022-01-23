package com.interview.linkedlist.fundamentals;


import com.interview.linkedlist.fundamentals.doublyll.DoublyLinkedListNode;
import com.interview.linkedlist.fundamentals.singlyll.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Stack;

public class LinkedListUtil {


    /**
     * Insert a node at the head of a linked list
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if (head == null) {
            return node;
        } else {
            node.next = head;
            head = node;
            return head;
        }
    }

    /**
     * Insert a Node at the Tail of a Linked List
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            return newNode;
        }
        SinglyLinkedListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        return head;
    }

    /**
     * Insert a node at a specific position in a linked list
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if (position == 0) {
            node.next = llist.next;
            llist = node;
        } else {
            SinglyLinkedListNode aux = new SinglyLinkedListNode(0);
            aux.next = llist;
            for (int i = 0; i < position; i++) aux = aux.next;
            node.next = aux.next;
            aux.next = node;
        }
        return llist;
    }

    /**
     * Delete a Node
     */

    static SinglyLinkedListNode deleteNodeAtPosition(SinglyLinkedListNode head, int position) {
        if (position > 0 && head.next == null) {
            return head;
        }
        if (position == 0 || head.next == null) {
            return head.next;
        }
        head.next = LinkedListUtil.deleteNodeAtPosition(head.next, position - 1);
        return head;
    }

    /**
     * Reverse a linked list
     */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedListNode remaining = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return remaining;
    }

    /**
     * Compare two linked lists
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null) {
            return false;
        } else if (head1.data != head2.data) {
            return false;
        }
        return compareLists(head1.next, head2.next);

    }

    /**
     * Merge two sorted linked lists
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        } else if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.data <= head2.data) {
            head1.next = mergeLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLists(head1, head2.next);
            return head2;
        }

    }

    /**
     * Test - Get Node Value
     */
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        for (int i = 0; i < positionFromTail; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    /**
     * Delete duplicate-value nodes from a sorted linked list
     */
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedListNode previousNode = head;
        SinglyLinkedListNode currentNode = head.next;
        while (currentNode != null) {
            if (previousNode.data == currentNode.data) {
                previousNode.next = currentNode.next;
            } else {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        return head;
    }

    /**
     * Cycle Detection
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        HashSet<SinglyLinkedListNode> s = new HashSet<>();
        while (head != null) {
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(head))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(head);

            head = head.next;
        }

        return false;
    }

    static boolean hasCycle2(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;

    }

    /**
     * Find Merge Point of Two Lists
     */
    static int findMergeNode(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
        SinglyLinkedListNode currentA = headA;
        SinglyLinkedListNode currentB = headB;

        //Do till the two SinglyLinkedListNodes are the same
        while (currentA != currentB) {
            //If you reached the end of one list start at the beginning of the other one
            //currentA
            if (currentA.next == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }
            //currentB
            if (currentB.next == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }
        return currentB.data;
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if (head == null) {
            return node;
        }
        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode prev = head;
        while (curr.data < data && curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == head) {
            node.next = head;
            head = node;
        } else if (curr.data < data) { //add at last
            node.prev = curr;
            curr.next = node;
        } else {
            node.next = curr;
            node.prev = prev;
            curr.prev = node;
            prev.next = node;
        }
        return head;
    }

    static DoublyLinkedListNode reverseADoublyLinkedList(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        DoublyLinkedListNode newHead = head;
        while (temp != null) {
            DoublyLinkedListNode prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            newHead = temp;
            temp = temp.prev;
        }
        return newHead;
    }


    static DoublyLinkedListNode reverseADoublyLinkedList2(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<DoublyLinkedListNode> stack = new Stack<>();
        DoublyLinkedListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int i = 0;
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode newHead = null;
        while (!stack.isEmpty()) {
            DoublyLinkedListNode curr = stack.pop();
            if (stack.isEmpty()) {
                curr.next = null;
                curr.prev = prev;
            } else {
                DoublyLinkedListNode next = stack.peek();
                curr.next = next;
                curr.prev = prev;
                prev = curr;
            }
            if (i == 0) {
                newHead = curr;
            }
            i++;
        }
        return newHead;
    }

    static void printSinglyLinkedList(SinglyLinkedListNode listNode) {

        if (listNode == null)
            System.out.print("null");
        while (listNode.next != null) {
            System.out.print(listNode.data + " → ");
            listNode = listNode.next;
        }
        System.out.print(listNode.data);
    }

    static void printDoublyLinkedList(DoublyLinkedListNode listNode) {

        if (listNode == null)
            System.out.println("Doubly linked list is empty");
        while (listNode.next != null) {
            System.out.print(listNode.data + " → ");
            listNode = listNode.next;
        }
        System.out.print(listNode.data);
    }



}
