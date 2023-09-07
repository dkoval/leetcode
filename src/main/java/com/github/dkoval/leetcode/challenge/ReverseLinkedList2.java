package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Reverse Linked List II</a>
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is n</li>
 *  <li>1 <= n <= 500</li>
 *  <li>-500 <= Node.val <= 500</li>
 *  <li>1 <= left <= right <= n</li>
 * </ul>
 * <p>
 * Follow up: Could you do it in one pass?
 */
public interface ReverseLinkedList2 {

    ListNode reverseBetween(ListNode head, int left, int right);

    class ReverseLinkedList2Rev1 implements ReverseLinkedList2 {

        // O(N) time | O(1) space
        public ListNode reverseBetween(ListNode head, int left, int right) {
            int idx = 1;
            ListNode curr = head;

            // find left node
            ListNode prevToLeftNode = null;
            while (curr != null && idx != left) {
                prevToLeftNode = curr;
                curr = curr.next;
                idx++;
            }

            ListNode leftNode = curr;

            // find right node
            while (curr != null && idx != right) {
                curr = curr.next;
                idx++;
            }

            ListNode rightNode = curr;
            ListNode nextToRightNode = curr.next;

            // reverse the sub-list between left and right pointers
            ListNode prev = nextToRightNode;
            curr = leftNode;
            while (curr != nextToRightNode) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // reversed list head
            if (prevToLeftNode != null) {
                prevToLeftNode.next = prev;
                return head;
            } else {
                return prev;
            }
        }
    }

    // O(N) time | O(1) space
    class ReverseLinkedList2Rev2 implements ReverseLinkedList2 {

        @Override
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }

            int idx = 1;
            ListNode curr = head;

            // find left node
            ListNode prevToLeftNode = null;
            while (curr != null && idx != left) {
                prevToLeftNode = curr;
                curr = curr.next;
                idx++;
            }

            ListNode leftNode = curr;

            // find right node
            while (curr != null && idx != right) {
                curr = curr.next;
                idx++;
            }

            ListNode rightNode = curr;
            ListNode nextToRightNode = rightNode.next;

            // reverse [left : right] sublist
            ListInfo res = reverse(leftNode, rightNode);

            ListNode newHead = head;
            if (prevToLeftNode != null) {
                prevToLeftNode.next = res.head;
            } else {
                newHead = res.head;
            }
            res.tail.next = nextToRightNode;
            return newHead;
        }

        private ListInfo reverse(ListNode start, ListNode end) {
            end.next = null; // stop here
            ListNode curr = start;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return new ListInfo(prev, start);
        }

        private static class ListInfo {
            final ListNode head;
            final ListNode tail;

            ListInfo(ListNode head, ListNode tail) {
                this.head = head;
                this.tail = tail;
            }
        }
    }

    // O(N) time | O(1) space
    class ReverseLinkedList2Rev3 implements ReverseLinkedList2 {

        @Override
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode leftNode = head;
            ListNode beforeLeftNode = null;

            ListNode curr = head;
            ListNode prev = null;
            for (int i = 1; i <= right; i++) {
                if (i == left) {
                    leftNode = curr;
                    beforeLeftNode = prev;
                }
                prev = curr;
                curr = curr.next;
            }

            ListNode rightNode = prev;
            ListNode afterRightNode = curr;

            reverseBetween(leftNode, rightNode);
            leftNode.next = afterRightNode;
            if (beforeLeftNode != null) {
                beforeLeftNode.next = rightNode;
            } else {
                head = rightNode;
            }
            return head;
        }

        private void reverseBetween(ListNode left, ListNode right) {
            ListNode curr = left;
            ListNode prev = null;
            ListNode stop = right.next;
            while (curr != stop) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
    }
}
