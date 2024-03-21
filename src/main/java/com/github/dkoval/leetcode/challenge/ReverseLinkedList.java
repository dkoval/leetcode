package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is the range [0, 5000]</li>
 *  <li>-5000 <= Node.val <= 5000</li>
 * </ul>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public interface ReverseLinkedList {

    ListNode reverseList(ListNode head);

    // O(N) time | O(1) space
    class ReverseLinkedListIterative implements ReverseLinkedList {

        @Override
        public ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    // O(N) time | O(N) space for recursion
    class ReverseLinkedListRecursive implements ReverseLinkedList {

        @Override
        public ListNode reverseList(ListNode node) {
            if (node == null || node.next == null) {
                return node;
            }

            // n[1] <- ...      <- n[k] -> n[k + 1] -> ... -> n[N]
            //                     ^ curr  ^ next
            // |-- already reversed --|    |-- to be reversed --|
            //                          -> remove, i.e. curr.next = null
            //                          <- create, i.e. next.next = curr
            // we want n[k + 1] to point to n[k], where n[k] is the current node
            ListNode next = node.next;
            node.next = null; // to avoid cycles

            ListNode head = reverseList(next);
            next.next = node; // make n[k + 1] point to n[k]
            return head; // head of the reversed list, i.e. n[N]
        }
    }
}
