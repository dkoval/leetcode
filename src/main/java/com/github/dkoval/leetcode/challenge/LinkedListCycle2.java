package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3509/">Linked List Cycle II</a>
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Notice that you should not modify the linked list.
 * <p>
 * Follow up:
 * <p>
 * Can you solve it using O(1) (i.e. constant) memory
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        // step 1 - detect if there is a cycle
        ListNode slow = head, fast = head;
        boolean found = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                found = true;
                break;
            }
        }
        if (!found) return null;

        // step 2 - compute length of the cycle
        slow = slow.next;
        int length = 1;
        while (slow != fast) {
            slow = slow.next;
            length++;
        }

        // step 3 - advance fast pointer by `length` steps ahead
        slow = head;
        fast = head;
        while (length-- > 0) {
            fast = fast.next;
        }

        // step 4 - advance slow and fast pointers by 1 step at a time until they meet
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
