package com.interview.linkedlist.medium;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbers() {

        int[] llElements1 = {2, 4, 3};
        ListNode listNode1 = ListNode.push(llElements1);


        int[] llElements2 = {5, 6, 4};
        ListNode listNode2 = ListNode.push(llElements2);

        int[] llElements3 = {7,0,8};
        ListNode expectedOutput = ListNode.push(llElements3);


        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode actualOutput = addTwoNumbers.addTwoNumbers(listNode1, listNode2);

        while (actualOutput != null) {
            Assert.assertEquals(expectedOutput.val, actualOutput.val);
            expectedOutput = expectedOutput.next;
            actualOutput =  actualOutput.next;
        }


    }

    @Test
    public void testAddTwoNumbers2() {

        int[] llElements1 = {9,9,9,9,9,9,9};
        ListNode listNode1 = ListNode.push(llElements1);


        int[] llElements2 = {9,9,9,9};
        ListNode listNode2 = ListNode.push(llElements2);

        int[] llElements3 = {8,9,9,9,0,0,0,1};
        ListNode expectedOutput = ListNode.push(llElements3);


        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode actualOutput = addTwoNumbers.addTwoNumbers(listNode1, listNode2);

        while (actualOutput != null) {
            Assert.assertEquals(expectedOutput.val, actualOutput.val);
            expectedOutput = expectedOutput.next;
            actualOutput =  actualOutput.next;
        }


    }
}
