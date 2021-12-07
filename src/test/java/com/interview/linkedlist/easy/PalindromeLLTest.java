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

        int llElements[]={1,2,3,4,5};
        ListNode listNode = ListNode.push(llElements);

        PalindromeLL palindromeLL = new PalindromeLL();
        boolean actualOutput = palindromeLL.isPalindrome (listNode);
        Assert.assertEquals(false, actualOutput);

    }

    @Test
    public void testIsPalindrome2() {

//        even
//        1 -> 2 -> 3 -> 4
//        left half:  1 -> 2
//        right half: 3 -> 4

        int llElements[]={1,2,3,4};
        ListNode listNode = ListNode.push(llElements);

        PalindromeLL palindromeLL = new PalindromeLL();
        boolean actualOutput = palindromeLL.isPalindrome (listNode);
        Assert.assertEquals(false, actualOutput);

    }
    @Test
    public void testIsPalindrome3() {

//        even
//        1 -> 2 -> 3 -> 4
//        left half:  1 -> 2
//        right half: 3 -> 4

        int llElements[]={1,2,2,1};
        ListNode listNode = ListNode.push(llElements);

        PalindromeLL palindromeLL = new PalindromeLL();
        boolean actualOutput = palindromeLL.isPalindrome (listNode);
        Assert.assertEquals(true, actualOutput);

    }
}
