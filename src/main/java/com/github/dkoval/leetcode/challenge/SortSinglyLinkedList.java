package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

public class SortSinglyLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(head2);
        return merge(left, right);
    }

    private ListNode middle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode(42);
        ListNode curr = dummy, p1 = head1, p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        curr.next = (p1 != null) ? p1 : p2;
        return dummy.next;
    }
}
