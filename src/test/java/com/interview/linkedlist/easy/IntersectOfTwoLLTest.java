package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IntersectOfTwoLLTest {
    @Test
    public void testGetIntersectionNode() {
        ListNode newNode;

        ListNode list1 = new ListNode(4);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(1);


        //As 8 is common node for list1 and list2
        newNode = new ListNode(8);
        list1.next = newNode;
        list2.next.next.next = newNode;

        //As 4 is common node for list1 and list2
        newNode = new ListNode(4);
        list1.next.next = newNode;
        list2.next.next.next.next = newNode;

        //As 5 is common node for list1 and list2
        newNode = new ListNode(5);
        list1.next.next.next = newNode;
        list2.next.next.next.next.next = newNode;




        ListNode expectedList = new ListNode(8);


        IntersectionOfTwoLL intersectionOfTwoLL = new IntersectionOfTwoLL();
        ListNode actualOutput = intersectionOfTwoLL.getIntersectionNode(list1, list2);
        ListNode.print(actualOutput);
        Assert.assertEquals(expectedList.val, actualOutput.val);

    }

    @Test
    public void testGetIntersectionNode2() {

 /*
    Create two linked lists

    1st Linked list is 3.6.9.15.30
    2nd Linked list is 10.15.30

    15 30 are elements in the intersection list
    */

        ListNode list1 = new ListNode(10);

        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(9);

        ListNode newNode = new ListNode();
        newNode.val = 15;

        list1.next = newNode;
        list2.next.next.next = newNode;

        newNode = new ListNode();
        newNode.val = 30;
        list1.next.next = newNode;
        list1.next.next.next = null;


        ListNode expectedList = new ListNode(15, new ListNode(30));

        IntersectionOfTwoLL intersectionOfTwoLL = new IntersectionOfTwoLL();
        ListNode actualOutput = intersectionOfTwoLL.getIntersectionNode(list1, list2);
        ListNode.print(actualOutput);

        Assert.assertEquals(expectedList.val, actualOutput.val);
        Assert.assertEquals(expectedList.next.val, actualOutput.next.val);

    }


    @Test
    public void testGetIntersectionNode1() {

        ListNode listNode = new ListNode(3, new ListNode(2));
        ListNode listNode2 = new ListNode(3, new ListNode(2));



        Assert.assertEquals(listNode, listNode2);
        Assert.assertEquals(listNode.hashCode(), listNode2.hashCode());

    }

}
