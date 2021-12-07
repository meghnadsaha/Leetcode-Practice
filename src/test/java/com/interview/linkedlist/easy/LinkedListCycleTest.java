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

        int[] llElements = {10, 15, 4, 20};
        ListNode listNodeHead = ListNode.push(llElements);


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

    @Test
    public void testMergeTwoLists3() {

//          HEAD→ → → → → →   3 → → → → →  2 → → → → 0
//                                         ↑         ↓
//                                          ← ← ← ← -4

        int[] llElements = {3, 2, 0, -4};
        ListNode listNodeHead = ListNode.push(llElements);


        // insert cycle
        listNodeHead.next.next.next = listNodeHead.next;

        boolean expectedOutput = true;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean actualOutput = linkedListCycle.hasCycle(listNodeHead);

        Assert.assertEquals(expectedOutput, actualOutput);

    }

}
