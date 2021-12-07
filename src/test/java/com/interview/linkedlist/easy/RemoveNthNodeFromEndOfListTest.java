package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {
    @Test
    public void testMergeTwoLists() {


        int[] llElements = {10, 15, 4, 20};
        ListNode listNodeHead = ListNode.push(llElements);


        // insert cycle
        listNodeHead.next.next.next.next = listNodeHead.next.next;

        boolean expectedOutput = true;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean actualOutput = linkedListCycle.hasCycle(listNodeHead);

        Assert.assertEquals(expectedOutput, actualOutput);

    }
}
