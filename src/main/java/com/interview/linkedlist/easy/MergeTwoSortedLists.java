package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode temp=head;

        while(l1!=null && l2!=null)//when both the list has some values compare one by one
        {
            if(l1.val<l2.val)//if l1 value is less then place it in the newly created list
            {
                temp.next=l1;
                temp=temp.next;
                l1=l1.next;
            }
            else//else place l2 values
            {
                temp.next=l2;
                temp=temp.next;
                l2=l2.next;
            }
        }

        if(l1==null)//if incase l1 is empty then need to print only l2
            temp.next=l2;
        else//else the opposite way then need to print only l1
            temp.next=l1;

        return head.next;
    }

}
