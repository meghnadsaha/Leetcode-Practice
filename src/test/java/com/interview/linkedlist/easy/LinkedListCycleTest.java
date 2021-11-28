package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {
    @Test
    public void testMergeTwoLists() {

        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(0);
        list1.next.next.next = new ListNode(-4);

        int position = 1;

        boolean expectedOutput = true;


        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean actualOutput = linkedListCycle.hasCycle(list1);

        Assert.assertEquals(expectedOutput, actualOutput);

    }

}
