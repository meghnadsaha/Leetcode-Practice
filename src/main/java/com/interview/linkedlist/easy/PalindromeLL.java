package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;

//https://leetcode.com/problems/palindrome-linked-list/discuss/316814/Java-Solution-Using-Two-Pointers-Half-Reverse-(easy-understand)

public class PalindromeLL {

    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;//1 2 3 4 5
        ListNode p2 = reverse(getRightHalf(head));//5 4
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode getRightHalf(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;  // left-leaning
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next; // important!//slow=3 4 5 //
    }

    private ListNode reverse(ListNode head) {//4 5
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            ListNode nextTemp = p.next;
            p.next = prev;
            prev = p;
            p = nextTemp;
        }
        return prev;//5 4
    }


}
