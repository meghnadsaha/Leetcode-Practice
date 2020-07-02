package com.interview.linkedlist;

public class ConvertBinaryNumberinALinkedListtoInteger {
	public int getDecimalValue(ListNode head) {
		int num = 0; // Initialise num to 0
		while (head != null) { 
			num <<= 1; // Left shift num by 1 position to make way for next bit
		 	num += head.val; // Add next bit to num at least significant
								// position
			head = head.next; // Update head
		}
		return num;
	}	
}
