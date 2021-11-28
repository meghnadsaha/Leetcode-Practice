package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {
    @Test
    public void testMergeTwoLists() {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(2);


        ListNode expectedList = new ListNode(1);
        expectedList.next = new ListNode(2);


        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode actualOutput = removeDuplicatesFromSortedList.deleteDuplicates(list1);

        Assert.assertEquals(expectedList, actualOutput);

    }

}
