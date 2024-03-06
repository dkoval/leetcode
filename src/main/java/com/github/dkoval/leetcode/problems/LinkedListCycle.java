package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">Linked List Cycle</a>
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of the nodes in the list is in the range [0, 10^4].</li>
 *  <li>-10^5 <= Node.val <= 10^5</li>
 *  <li>pos is -1 or a valid index in the linked-list</li>
 * </ul>
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
