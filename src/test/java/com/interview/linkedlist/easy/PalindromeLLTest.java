package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeLLTest {

    @Test
    public void testIsPalindrome() {

//        odd
//        1 -> 2 -> 3 -> 4 -> 5
//        left half:  1 -> 2
//        right half: 4 -> 5

        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);


        PalindromeLL palindromeLL = new PalindromeLL();
        boolean actualOutput = palindromeLL.isPalindrome (listNode);
        boolean expectedList = false;
        Assert.assertEquals(expectedList, actualOutput);

    }

    @Test
    public void testIsPalindrome2() {

//        even
//        1 -> 2 -> 3 -> 4
//        left half:  1 -> 2
//        right half: 3 -> 4


        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);


        PalindromeLL palindromeLL = new PalindromeLL();
        boolean actualOutput = palindromeLL.isPalindrome (listNode);
        boolean expectedList = false;
        Assert.assertEquals(expectedList, actualOutput);

    }
    @Test
    public void testIsPalindrome3() {

//        even
//        1 -> 2 -> 3 -> 4
//        left half:  1 -> 2
//        right half: 3 -> 4


        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(1);


        PalindromeLL palindromeLL = new PalindromeLL();
        boolean actualOutput = palindromeLL.isPalindrome (listNode);
        boolean expectedList = true;
        Assert.assertEquals(expectedList, actualOutput);

    }
}
