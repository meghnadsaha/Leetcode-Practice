package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {
    @Test
    public void testMergeTwoLists() {

//          HEAD     →   10     →      15
//                        ↑             ↓
//                        20     ←      4

        int[] keys = {10, 15, 4, 20};
        ListNode listNodeHead = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            listNodeHead = new ListNode(keys[i], listNodeHead);
        }

        // insert cycle
        listNodeHead.next.next.next.next = listNodeHead.next.next;

        boolean expectedOutput = true;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean actualOutput = linkedListCycle.hasCycle(listNodeHead);

        Assert.assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void testMergeTwoLists2() {



        boolean expectedOutput = false;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean actualOutput = linkedListCycle.hasCycle(new ListNode(1));

        Assert.assertEquals(expectedOutput, actualOutput);

    }

}
