package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLLTest {
    @Test
    public void testReverseList() {

        int[] keys = {1, 2, 3, 4, 5};
        ListNode listNodeHead = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            listNodeHead = new ListNode(keys[i], listNodeHead);
        }

        int[] expectedKeys = {5, 4, 3, 2, 1};
        ListNode expectedListNodeHead = null;
        for (int i = 0; i < keys.length; i++) {
            expectedListNodeHead = new ListNode(keys[i], expectedListNodeHead);
        }

        ReverseLL reverseLL = new ReverseLL();
        ListNode actualOutput = reverseLL.reverseList(listNodeHead);

        while (actualOutput.next != null) {
            Assert.assertEquals(expectedListNodeHead.val, actualOutput.val);
            actualOutput = actualOutput.next;
            expectedListNodeHead = expectedListNodeHead.next;
        }

    }
}
