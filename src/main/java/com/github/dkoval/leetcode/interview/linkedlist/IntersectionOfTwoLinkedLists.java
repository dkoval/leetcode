package com.github.dkoval.leetcode.interview.linkedlist;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * Notes:
 * <ul>
 * <li>If the two linked lists have no intersection at all, return null.</li>
 * <li>The linked lists must retain their original structure after the function returns.</li>
 * <li>You may assume there are no cycles anywhere in the entire linked structure.</li>
 * <li>Each value on each linked list is in the range [1, 10^9].</li>
 * <li>Your code should preferably run in O(n) time and use only O(1) memory.</li>
 * </ul>
 */
public class IntersectionOfTwoLinkedLists {

    // O(N) time | O(1) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                lengthA++;
                p1 = p1.next;
            }
            if (p2 != null) {
                lengthB++;
                p2 = p2.next;
            }
        }

        int diff = Math.abs(lengthA - lengthB);
        // p1 points to the head of the longest list
        p1 = (lengthA > lengthB) ? headA : headB;
        // p2 points to the head of the shortest list
        p2 = (p1 == headA) ? headB : headA;

        // skip `diff` number of nodes in the longest list
        while (diff-- > 0) {
            p1 = p1.next;
        }

        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
