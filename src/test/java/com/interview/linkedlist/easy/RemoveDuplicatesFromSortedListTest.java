package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {
    @Test
    public void testMergeTwoLists() {

        int llElements[]={1,2,2};
        ListNode ll = ListNode.push(llElements);

        int expectedLLElements[]={1,2};
        ListNode expectedLL = ListNode.push(llElements);


        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode actualLL = removeDuplicatesFromSortedList.deleteDuplicates(ll);

        while (actualLL.next != null) {
            Assert.assertEquals(expectedLL.val, actualLL.val);
            actualLL = actualLL.next;
            expectedLL = expectedLL.next;
        }
    }

}
