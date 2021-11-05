package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3966/">Reverse Linked List</a>
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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // n[1] -> ... -> n[k] <- n[k + 1] <- ... <- n[N]
            //                        ^ already reversed ^
            // we want n[k + 1] to point to n[k], where n[k] is the current `head`
            ListNode headOfReversedList = reverseList(head.next);
            head.next.next = head; // make n[k + 1] point to n[k]
            head.next = null; // to avoid cycles
            return headOfReversedList; // head of the reversed list, i.e. n[N]
        }
    }
}
