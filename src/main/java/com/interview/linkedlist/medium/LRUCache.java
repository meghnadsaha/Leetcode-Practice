package com.interview.linkedlist.medium;

import com.interview.linkedlist.others.Node;

public class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DLL {
        Node head;    /* to track the head of the double linked list  */
        Node currNode;    /* to track the latest node placed in the double linked list */

        /* method to remove a node from a linkedlist chain. */
        public Node remove(Node node) {
            //check if head is to be removed.
            if (node == head) {
                //if head is the only element in the linkedlist chain
                if (currNode == head) {
                    currNode = head = null;
                    return node;
                }
                head = head.next;
            }

            //remove a node from middle of the chain
            else if (node.prev != null && node.next != null) {
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }

            //remove a node from the end of the chain
            else if (node.next == null) {
                currNode = node.prev;
                currNode.next = null;
            }
            return node;
        }

        /*  method to add a node to a linkedlist chain.  */
        public void add(Node node) {
            //check if head is null and add the first element into the linkedlist chain.
            if (head == null) {
                head = node;
                currNode = node;
            }

            //add at the end of an existing chain
            else {
                currNode.next = node;
                node.prev = currNode;
                node.next = null;
                currNode = currNode.next;
            }
        }
    }

    Node[] arr;
    int size = 0;   /*  to track the current size of the list   */
    int capacity = 0;
    DLL dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dll = new DLL();
        this.arr = new Node[10000];
    }

    public int get(int key) {
        if (arr[key] == null) {
            return -1;
        }
        Node node = arr[key];
        if (node.next != null) {
            this.dll.remove(node);
            this.dll.add(node);
        }
        return node.val;
    }

    public void put(int key, int val) {
        if (arr[key] != null) {
            arr[key].val = val;
            this.dll.remove(arr[key]);
            this.dll.add(arr[key]);
            return;
        }
        Node node = null;
        this.size++;
        if (size > capacity) {
            this.arr[dll.head.key] = null;
            node = this.dll.remove(dll.head);
            size--;
        }
        if (node != null) {
            node.key = key;
            node.val = val;
        } else {
            node = new Node(key, val);
        }
        this.dll.add(node);
        arr[key] = node;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     */
    public static void main(String args[]) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
