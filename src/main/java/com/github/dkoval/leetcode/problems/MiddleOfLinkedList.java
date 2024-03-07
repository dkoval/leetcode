package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Middle of the Linked List</a>
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 100]</li>
 *  <li>1 <= Node.val <= 100</li>
 * </ul>
 */
public interface MiddleOfLinkedList {

    ListNode middleNode(ListNode head);

    class MiddleOfLinkedListRev1 implements MiddleOfLinkedList {

        @Override
        public ListNode middleNode(ListNode head) {
            ListNode curr = head;
            int size = 0;
            while (curr != null) {
                size++;
                curr = curr.next;
            }

            int mid = size / 2;
            curr = head;
            while (mid-- > 0) {
                curr = curr.next;
            }
            return curr;
        }
    }

    class MiddleOfLinkedListRev2 implements MiddleOfLinkedList {

        @Override
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
