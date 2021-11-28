package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedListsTest {
    @Test
    public void testMergeTwoLists() {

        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);


        ListNode list2 = new ListNode(1);
        list2.next=new ListNode(3);
        list2.next.next=new ListNode(4);


        ListNode expectedList = new ListNode(1);
        expectedList.next=new ListNode(1);
        expectedList.next.next=new ListNode(2);
        expectedList.next.next.next=new ListNode(3);
        expectedList.next.next.next.next=new ListNode(4);
        expectedList.next.next.next.next.next=new ListNode(4);


        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode actualOutput = mergeTwoSortedLists.mergeTwoLists(list1, list2);

        Assert.assertEquals(expectedList, actualOutput);

    }

}
